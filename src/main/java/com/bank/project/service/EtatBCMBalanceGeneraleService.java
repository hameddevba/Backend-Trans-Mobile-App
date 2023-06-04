package com.bank.project.service;

import com.bank.project.dao.EtatBCMBalanceGeneraleDao;
import com.bank.project.model.EtatBCMBalanceGenerale;
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
public class EtatBCMBalanceGeneraleService {
    @Autowired
    private EtatBCMBalanceGeneraleDao etatBCMBalanceGeneraleDao;

    @Autowired
    private PublishService publishService;

    public List<EtatBCMBalanceGenerale> findAll() {
        return etatBCMBalanceGeneraleDao.findAll(Sort.by("compte"));
    }

    public Page<EtatBCMBalanceGenerale> findEchantillon(int page, int size) {
        return etatBCMBalanceGeneraleDao.findAll(PageRequest.of(page, size, Sort.by("id")));
    }

    public EtatBCMBalanceGenerale findById(final Long id) {
        return etatBCMBalanceGeneraleDao.findById(id).orElse(null);
    }

    public boolean update(final EtatBCMBalanceGenerale etatBCMBalanceGenerale) {
        Optional<EtatBCMBalanceGenerale> etatBCMBalanceGeneraleSavedOp = etatBCMBalanceGeneraleDao.findById(etatBCMBalanceGenerale.getId());
        if (etatBCMBalanceGeneraleSavedOp.isPresent()) {
            EtatBCMBalanceGenerale etatBCMBalanceGeneraleSaved = etatBCMBalanceGeneraleSavedOp.get();
            etatBCMBalanceGeneraleSaved.setCompte(etatBCMBalanceGenerale.getCompte());
            etatBCMBalanceGeneraleSaved.setSoldeCrediteur(etatBCMBalanceGenerale.getSoldeCrediteur());
            etatBCMBalanceGeneraleSaved.setSoldeDebiteur(etatBCMBalanceGenerale.getSoldeDebiteur());
            etatBCMBalanceGeneraleSaved.setResident(etatBCMBalanceGenerale.getResident());
            etatBCMBalanceGeneraleSaved.setDateClotureBalance(etatBCMBalanceGenerale.getDateClotureBalance());
            etatBCMBalanceGeneraleSaved.setIntituleCompte(etatBCMBalanceGenerale.getIntituleCompte());
            etatBCMBalanceGeneraleSaved.setBanque(etatBCMBalanceGenerale.getBanque());
            etatBCMBalanceGeneraleDao.save(etatBCMBalanceGeneraleSaved);
            return true;
        }
        return false;
    }

    public StringWriter exportData() throws IOException {
        List<EtatBCMBalanceGenerale> etatBCMBalanceGenerales = etatBCMBalanceGeneraleDao.findAll();
        String[] headers = new String[]{
                "compte", "banque", "date de cloture", "intitule de Compte", "devise",
                "resident", "solde debiteur", "solde crediteur",
        };
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(headers)
                .setDelimiter(";")
                .build();
        StringWriter sw = new StringWriter();
        try (final CSVPrinter printer = new CSVPrinter(sw, csvFormat)) {
            etatBCMBalanceGenerales.forEach(report -> {
                try {
                    printer.printRecord(report.getCompte(), report.getBanque(), report.getDateClotureBalance(), report.getIntituleCompte()
                            , report.getDevise(), report.getResident(), report.getSoldeDebiteur(), report.getSoldeCrediteur());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        return sw;
    }

}
