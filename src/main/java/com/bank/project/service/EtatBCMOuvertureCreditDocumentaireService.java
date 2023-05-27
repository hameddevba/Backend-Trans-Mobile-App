package com.bank.project.service;

import com.bank.project.dao.EtatBCMOuvertureCreditDocumentaireDao;
import com.bank.project.model.EtatBCMOuvertureCreditDocumentaire;
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
public class EtatBCMOuvertureCreditDocumentaireService {
    @Autowired
    private EtatBCMOuvertureCreditDocumentaireDao etatBCMOuvertureCreditDocumentaireDao;


    public List<EtatBCMOuvertureCreditDocumentaire> findAll() {
        return etatBCMOuvertureCreditDocumentaireDao.findAll(Sort.by("id"));
    }

    public Page<EtatBCMOuvertureCreditDocumentaire> findEchantillon(int page, int size) {
        return etatBCMOuvertureCreditDocumentaireDao.findAll(PageRequest.of(page, size, Sort.by("id")));
    }

    public EtatBCMOuvertureCreditDocumentaire findById(final Long id) {
        return etatBCMOuvertureCreditDocumentaireDao.findById(id).orElse(null);
    }

    public boolean update(final EtatBCMOuvertureCreditDocumentaire etatBCMOuvertureCreditDocumentaire) {
        Optional<EtatBCMOuvertureCreditDocumentaire> etatBCMOuvertureCreditDocumentaireSavedOp = etatBCMOuvertureCreditDocumentaireDao.findById(etatBCMOuvertureCreditDocumentaire.getId());
        if (etatBCMOuvertureCreditDocumentaireSavedOp.isPresent()) {
            EtatBCMOuvertureCreditDocumentaire etatBCMOuvertureCreditDocumentaireSaved = etatBCMOuvertureCreditDocumentaireSavedOp.get();
            etatBCMOuvertureCreditDocumentaireSaved.setBanque(etatBCMOuvertureCreditDocumentaire.getBanque());
            etatBCMOuvertureCreditDocumentaireSaved.setDateOuverture(etatBCMOuvertureCreditDocumentaire.getDateOuverture());
            etatBCMOuvertureCreditDocumentaireSaved.setBeneficiaire(etatBCMOuvertureCreditDocumentaire.getBeneficiaire());
            etatBCMOuvertureCreditDocumentaireSaved.setMontantOuverture(etatBCMOuvertureCreditDocumentaire.getMontantOuverture());
            etatBCMOuvertureCreditDocumentaireSaved.setDevise(etatBCMOuvertureCreditDocumentaire.getDevise());
            etatBCMOuvertureCreditDocumentaireSaved.setNomCorrespondant(etatBCMOuvertureCreditDocumentaire.getNomCorrespondant());
            etatBCMOuvertureCreditDocumentaireSaved.setNomDonneurOrdre(etatBCMOuvertureCreditDocumentaire.getNomDonneurOrdre());
            etatBCMOuvertureCreditDocumentaireSaved.setNumCredoc(etatBCMOuvertureCreditDocumentaire.getNumCredoc());
            etatBCMOuvertureCreditDocumentaireSaved.setProduit(etatBCMOuvertureCreditDocumentaire.getProduit());
            etatBCMOuvertureCreditDocumentaireSaved.setDeposite(etatBCMOuvertureCreditDocumentaire.getDeposite());
            etatBCMOuvertureCreditDocumentaireSaved.setPays(etatBCMOuvertureCreditDocumentaire.getPays());


            etatBCMOuvertureCreditDocumentaireDao.save(etatBCMOuvertureCreditDocumentaireSaved);
            return true;
        }
        return false;
    }

    public StringWriter exportData() throws IOException {
        List<EtatBCMOuvertureCreditDocumentaire> etatBCMOuvertureCreditDocumentaires = etatBCMOuvertureCreditDocumentaireDao.findAll();
        String[] headers = new String[]{
                "banque", "beneficiaire", "date d'ouverture", "deposite",
                "devise", "montant d'ouverture", "nom de correspondant", "nom de donneur d'ordre",
                "num_credoc", "pays", "produit",
        };
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(headers)
                .setDelimiter(";")
                .build();
        StringWriter sw = new StringWriter();
        try (final CSVPrinter printer = new CSVPrinter(sw, csvFormat)) {
            etatBCMOuvertureCreditDocumentaires.forEach(report -> {
                try {
                    printer.printRecord(report.getBanque(), report.getBeneficiaire(), report.getDateOuverture(), report.getDeposite(),
                            report.getDevise(), report.getMontantOuverture(), report.getNomCorrespondant(),
                            report.getNomDonneurOrdre(), report.getNumCredoc(), report.getPays(),report.getProduit());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        return sw;
    }
}
