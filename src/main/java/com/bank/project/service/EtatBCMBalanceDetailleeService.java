package com.bank.project.service;

import com.bank.project.dao.EtatBCMBalanceDetailleeDao;
import com.bank.project.model.EtatBCMBalanceDetaillee;
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
public class EtatBCMBalanceDetailleeService {
    @Autowired
    private EtatBCMBalanceDetailleeDao etatBCMBalanceDetailleeDao;

    public List<EtatBCMBalanceDetaillee> findAll() {
        return etatBCMBalanceDetailleeDao.findAll(Sort.by("id"));
    }
    public Page<EtatBCMBalanceDetaillee> findEchantillon(int page,int size) {
        return etatBCMBalanceDetailleeDao.findAll(PageRequest.of(page, size,Sort.by("id")));
    }

    public EtatBCMBalanceDetaillee findById(final Long id) {
        return etatBCMBalanceDetailleeDao.findById(id).orElse(null);
    }

    public boolean update(final EtatBCMBalanceDetaillee etatBCMBalanceDetaillee) {
        Optional<EtatBCMBalanceDetaillee> etatBCMBalanceDetailleeSavedOp = etatBCMBalanceDetailleeDao.findById(etatBCMBalanceDetaillee.getId());
        if(etatBCMBalanceDetailleeSavedOp.isPresent()){
        EtatBCMBalanceDetaillee etatBCMBalanceDetailleeSaved = etatBCMBalanceDetailleeSavedOp.get();
            etatBCMBalanceDetailleeSaved.setSoldeCrediteur(etatBCMBalanceDetaillee.getSoldeCrediteur());
            etatBCMBalanceDetailleeSaved.setSoldeDebiteur(etatBCMBalanceDetaillee.getSoldeDebiteur());
            etatBCMBalanceDetailleeSaved.setResident(etatBCMBalanceDetaillee.getResident());
            etatBCMBalanceDetailleeSaved.setDateClotureBalance(etatBCMBalanceDetaillee.getDateClotureBalance());
            etatBCMBalanceDetailleeSaved.setCompte(etatBCMBalanceDetaillee.getCompte());
            etatBCMBalanceDetailleeSaved.setIntituleCompteComptable(etatBCMBalanceDetaillee.getIntituleCompteComptable());
            etatBCMBalanceDetailleeSaved.setCompteBancaireClient(etatBCMBalanceDetaillee.getCompteBancaireClient());
            etatBCMBalanceDetailleeSaved.setIntituleCompteBancaire(etatBCMBalanceDetaillee.getIntituleCompteBancaire());
            etatBCMBalanceDetailleeSaved.setActiviteClient(etatBCMBalanceDetaillee.getActiviteClient());
            etatBCMBalanceDetailleeSaved.setSecteurActiviteClient(etatBCMBalanceDetaillee.getSecteurActiviteClient());
            etatBCMBalanceDetailleeSaved.setEstClientApparente(etatBCMBalanceDetaillee.getEstClientApparente());
            etatBCMBalanceDetailleeSaved.setBanque(etatBCMBalanceDetaillee.getBanque());
            etatBCMBalanceDetailleeSaved.setDevise(etatBCMBalanceDetaillee.getDevise());


        etatBCMBalanceDetailleeDao.save(etatBCMBalanceDetailleeSaved);
            return true;
        }
        return false;
    }
    public StringWriter exportData() throws IOException {
        List<EtatBCMBalanceDetaillee> etatBCMBalanceDetaillees = etatBCMBalanceDetailleeDao.findAll();
        String[] headers = new String[]{
                "Banque", "compte", "dateClotureBalance", "intituleCompteComptable"
                , "compteBancaireClient", "intituleCompteBancaire", "resident"
                , "estClientApparente", "devise", "activiteClient", "secteurActiviteClient"
                , "soldeDebiteur", "soldeCrediteur"
        };
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(headers)
                .setDelimiter(";")
                .build();
        StringWriter sw = new StringWriter();
        try (final CSVPrinter printer = new CSVPrinter(sw, csvFormat)) {
            etatBCMBalanceDetaillees.forEach(report -> {
                try {
                    printer.printRecord(report.getBanque(), report.getCompte(),report.getDateClotureBalance(),report.getIntituleCompteComptable()
                            ,report.getCompteBancaireClient(),report.getIntituleCompteBancaire(),report.getResident()
                            ,report.getEstClientApparente(),report.getDevise(),report.getActiviteClient(),report.getSecteurActiviteClient()
                            ,report.getSoldeDebiteur(),report.getSoldeCrediteur());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        return sw;
    }
}
