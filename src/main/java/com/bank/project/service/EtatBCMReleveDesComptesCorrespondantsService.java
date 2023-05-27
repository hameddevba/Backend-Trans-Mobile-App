package com.bank.project.service;

import com.bank.project.dao.EtatBCMReleveDesComptesCorrespondantsDao;
import com.bank.project.model.EtatBCMReleveDesComptesCorrespondants;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Optional;


@Service
public class EtatBCMReleveDesComptesCorrespondantsService {
    @Autowired
    private EtatBCMReleveDesComptesCorrespondantsDao etatBCMReleveDesComptesCorrespondantsDao;


    public List<EtatBCMReleveDesComptesCorrespondants> findAll() {
        return etatBCMReleveDesComptesCorrespondantsDao.findAll(Sort.by("id"));
    }

    public Page<EtatBCMReleveDesComptesCorrespondants> findEchantillon(int page, int size) {
        return etatBCMReleveDesComptesCorrespondantsDao.findAll(PageRequest.of(page, size, Sort.by("id")));
    }

    public EtatBCMReleveDesComptesCorrespondants findById(final Long id) {
        return etatBCMReleveDesComptesCorrespondantsDao.findById(id).orElse(null);
    }

    public boolean update(final EtatBCMReleveDesComptesCorrespondants etatBCMReleveDesComptesCorrespondant) {
        Optional<EtatBCMReleveDesComptesCorrespondants> etatBCMReleveDesComptesCorrespondantsOp = etatBCMReleveDesComptesCorrespondantsDao.findById(etatBCMReleveDesComptesCorrespondant.getId());
        if (etatBCMReleveDesComptesCorrespondantsOp.isPresent()) {
            EtatBCMReleveDesComptesCorrespondants etatBCMReleveDesComptesCorrespondantsSaved = etatBCMReleveDesComptesCorrespondantsOp.get();
            etatBCMReleveDesComptesCorrespondantsSaved.setBanque(etatBCMReleveDesComptesCorrespondant.getBanque());
            etatBCMReleveDesComptesCorrespondantsSaved.setNomCorrespondant(etatBCMReleveDesComptesCorrespondant.getNomCorrespondant());
            etatBCMReleveDesComptesCorrespondantsSaved.setNumCompte(etatBCMReleveDesComptesCorrespondant.getNumCompte());
            etatBCMReleveDesComptesCorrespondantsSaved.setDevise(etatBCMReleveDesComptesCorrespondant.getDevise());
            etatBCMReleveDesComptesCorrespondantsSaved.setDateApCloture(etatBCMReleveDesComptesCorrespondant.getDateApCloture());
            etatBCMReleveDesComptesCorrespondantsSaved.setSoldeDebutJournee(etatBCMReleveDesComptesCorrespondant.getSoldeFinJournee());
            etatBCMReleveDesComptesCorrespondantsSaved.setTotalMvtsDebiteursJournee(etatBCMReleveDesComptesCorrespondant.getTotalMvtsDebiteursJournee());
            etatBCMReleveDesComptesCorrespondantsSaved.setTotalMvtsCrediteurs(etatBCMReleveDesComptesCorrespondant.getTotalMvtsCrediteurs());
            etatBCMReleveDesComptesCorrespondantsSaved.setSoldeFinJournee(etatBCMReleveDesComptesCorrespondant.getSoldeFinJournee());
            etatBCMReleveDesComptesCorrespondantsSaved.setDateFinJournee(etatBCMReleveDesComptesCorrespondant.getDateFinJournee());
            etatBCMReleveDesComptesCorrespondantsDao.save(etatBCMReleveDesComptesCorrespondantsSaved);
            return true;
        }
        return false;
    }

    public StringWriter exportData() throws IOException {
        List<EtatBCMReleveDesComptesCorrespondants> etatBCMReleveDesComptesCorrespondants = etatBCMReleveDesComptesCorrespondantsDao.findAll();
        String[] headers = new String[]{
                "banque", "nom correspondant", "numero de compte", "date Ap Cloture", "devise", "solde début Journée",
                "total Mvts Debiteurs Journee", "total Mvts Crediteurs", "solde Fin Journee", "Date Fin Journee",
        };
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(headers)
                .setDelimiter(";")
                .build();
        StringWriter sw = new StringWriter();
        try (final CSVPrinter printer = new CSVPrinter(sw, csvFormat)) {
            etatBCMReleveDesComptesCorrespondants.forEach(report -> {
                try {
                    printer.printRecord(report.getBanque(), report.getNomCorrespondant(), report.getNumCompte(), report.getDateApCloture(),
                            report.getDevise(), report.getSoldeDebutJournee(), report.getTotalMvtsDebiteursJournee(), report.getTotalMvtsCrediteurs(),
                            report.getSoldeFinJournee(), report.getDateFinJournee());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        return sw;
    }
}
