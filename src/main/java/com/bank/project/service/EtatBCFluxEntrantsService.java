package com.bank.project.service;

import com.bank.project.dao.EtatBCMFluxEntrantsDao;
import com.bank.project.model.EtatBCMFluxEntrants;
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
public class EtatBCFluxEntrantsService {
    @Autowired
    private EtatBCMFluxEntrantsDao etatBCMFluxEntrantsDao;


    public List<EtatBCMFluxEntrants> findAll() {
        return etatBCMFluxEntrantsDao.findAll(Sort.by("id"));
    }
    public Page<EtatBCMFluxEntrants> findEchantillon(int page, int size) {
        return etatBCMFluxEntrantsDao.findAll(PageRequest.of(page, size,Sort.by("id")));
    }
    public EtatBCMFluxEntrants findById(final Long id) {
        return etatBCMFluxEntrantsDao.findById(id).orElse(null);
    }

    public boolean update(final EtatBCMFluxEntrants etatBCMFluxEntrants) {
        Optional<EtatBCMFluxEntrants> etatBCMFluxEntrantSavedOp = etatBCMFluxEntrantsDao.findById(etatBCMFluxEntrants.getId());
        if(etatBCMFluxEntrantSavedOp.isPresent()){
            EtatBCMFluxEntrants etatBCMFluxEntrantSaved = etatBCMFluxEntrantSavedOp.get();
            etatBCMFluxEntrantSaved.setBanque(etatBCMFluxEntrants.getBanque());
            etatBCMFluxEntrantSaved.setDevise(etatBCMFluxEntrants.getDevise());
            etatBCMFluxEntrantSaved.setReferenceTransaction(etatBCMFluxEntrants.getReferenceTransaction());
            etatBCMFluxEntrantSaved.setDateTransaction(etatBCMFluxEntrants.getDateTransaction());
            etatBCMFluxEntrantSaved.setTypeSwfit(etatBCMFluxEntrants.getTypeSwfit());
            etatBCMFluxEntrantSaved.setModeReglement(etatBCMFluxEntrants.getModeReglement());
            etatBCMFluxEntrantSaved.setMontantTransaction(etatBCMFluxEntrants.getMontantTransaction());
            etatBCMFluxEntrantSaved.setTauxDeChange(etatBCMFluxEntrants.getTauxDeChange());
            etatBCMFluxEntrantSaved.setNomDonneurOrdre(etatBCMFluxEntrants.getNomDonneurOrdre());
            etatBCMFluxEntrantSaved.setNifNni(etatBCMFluxEntrants.getNifNni());
            etatBCMFluxEntrantSaved.setBeneficiaire(etatBCMFluxEntrants.getBeneficiaire());
            etatBCMFluxEntrantSaved.setProduit(etatBCMFluxEntrants.getProduit());
            etatBCMFluxEntrantSaved.setNatureEconomique(etatBCMFluxEntrants.getNatureEconomique());
            etatBCMFluxEntrantSaved.setPays(etatBCMFluxEntrants.getPays());
            etatBCMFluxEntrantsDao.save(etatBCMFluxEntrantSaved);
            return true;
        }
        return false;
    }
    public StringWriter exportData() throws IOException {
        List<EtatBCMFluxEntrants> etatBCMFluxEntrants = etatBCMFluxEntrantsDao.findAll();
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
            etatBCMFluxEntrants.forEach(report -> {
                try {
                    printer.printRecord(report.getBanque(), report.getReferenceTransaction(), report.getDateTransaction(), report.getTypeSwfit(),
                            report.getModeReglement(), report.getDevise(), report.getMontantTransaction(), report.getTauxDeChange(),report.getNomDonneurOrdre(), report.getNifNni(),
                            report.getDevise(), report.getBeneficiaire(), report.getProduit(), report.getNatureEconomique(), report.getPays());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        return sw;
    }
}
