package com.bank.project.service;

import com.bank.project.dao.EtatBCMFluxSortantsDao;
import com.bank.project.model.EtatBCMFluxSortants;
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
public class EtatBCMFluxSortantsService {
    @Autowired
    private EtatBCMFluxSortantsDao etatBCMFluxSortantsDao;


    public List<EtatBCMFluxSortants> findAll() {
        return etatBCMFluxSortantsDao.findAll(Sort.by("id"));
    }

    public Page<EtatBCMFluxSortants> findEchantillon(int page, int size) {
        return etatBCMFluxSortantsDao.findAll(PageRequest.of(page, size, Sort.by("id")));
    }

    public EtatBCMFluxSortants findById(final Long id) {
        return etatBCMFluxSortantsDao.findById(id).orElse(null);
    }

    public boolean update(final EtatBCMFluxSortants etatBCMFluxSortants) {
        Optional<EtatBCMFluxSortants> etatBCMFluxSortantsSavedOp = etatBCMFluxSortantsDao.findById(etatBCMFluxSortants.getId());
        if (etatBCMFluxSortantsSavedOp.isPresent()) {
            EtatBCMFluxSortants etatBCMFluxSortantsSaved = etatBCMFluxSortantsSavedOp.get();
            etatBCMFluxSortantsSaved.setBanque(etatBCMFluxSortants.getBanque());
            etatBCMFluxSortantsSaved.setDevise(etatBCMFluxSortants.getDevise());
            etatBCMFluxSortantsSaved.setBeneficiaire(etatBCMFluxSortants.getBeneficiaire());
            etatBCMFluxSortantsSaved.setDateTransaction(etatBCMFluxSortants.getDateTransaction());
            etatBCMFluxSortantsSaved.setModeReglement(etatBCMFluxSortants.getModeReglement());
            etatBCMFluxSortantsSaved.setMontantTransaction(etatBCMFluxSortants.getMontantTransaction());
            etatBCMFluxSortantsSaved.setNifNni(etatBCMFluxSortants.getNifNni());
            etatBCMFluxSortantsSaved.setNomDonneurOrdre(etatBCMFluxSortants.getNomDonneurOrdre());
            etatBCMFluxSortantsSaved.setPays(etatBCMFluxSortants.getPays());
            etatBCMFluxSortantsSaved.setProduit(etatBCMFluxSortants.getProduit());
            etatBCMFluxSortantsSaved.setReferenceTransaction(etatBCMFluxSortants.getReferenceTransaction());
            etatBCMFluxSortantsSaved.setSourceDevise(etatBCMFluxSortants.getSourceDevise());
            etatBCMFluxSortantsSaved.setTauxDeChange(etatBCMFluxSortants.getTauxDeChange());
            etatBCMFluxSortantsSaved.setTypeSwfit(etatBCMFluxSortants.getTypeSwfit());
            etatBCMFluxSortantsSaved.setNatureEconomique(etatBCMFluxSortants.getNatureEconomique());


            etatBCMFluxSortantsDao.save(etatBCMFluxSortantsSaved);
            return true;
        }
        return false;
    }

    public StringWriter exportData() throws IOException {
        List<EtatBCMFluxSortants> etatBCMFluxSortants = etatBCMFluxSortantsDao.findAll();
        String[] headers = new String[]{
                "Banque", "reference de transaction", "date de transaction",
                "type swfit", "mode de reglement", "devise", "montant de transaction",
                "taux de change", "nom de donneur d'ordre",
                "nifNni", "source devise", "beneficiaire", "produit",
                "Nature Economique", "pays",
        };
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(headers)
                .setDelimiter(";")
                .build();
        StringWriter sw = new StringWriter();
        try (final CSVPrinter printer = new CSVPrinter(sw, csvFormat)) {
            etatBCMFluxSortants.forEach(report -> {
                try {
                    printer.printRecord(report.getBanque(), report.getReferenceTransaction(), report.getDateTransaction(), report.getTypeSwfit(),
                            report.getModeReglement(), report.getDevise(), report.getMontantTransaction(), report.getTauxDeChange(), report.getNifNni(),
                            report.getSourceDevise(), report.getBeneficiaire(), report.getProduit(), report.getNatureEconomique(), report.getPays());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        return sw;
    }
}
