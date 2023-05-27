package com.bank.project.service;

import com.bank.project.dao.EtatBCMPrevisionEcheanceDao;
import com.bank.project.model.EtatBCMPrevisionEcheance;
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
public class EtatBCMPrevisionEcheanceService {
    @Autowired
    private EtatBCMPrevisionEcheanceDao etatBCMPrevisionEcheanceDao;


    public List<EtatBCMPrevisionEcheance> findAll() {
        return etatBCMPrevisionEcheanceDao.findAll(Sort.by("id"));
    }

    public Page<EtatBCMPrevisionEcheance> findEchantillon(int page, int size) {
        return etatBCMPrevisionEcheanceDao.findAll(PageRequest.of(page, size, Sort.by("id")));
    }

    public EtatBCMPrevisionEcheance findById(final Long id) {
        return etatBCMPrevisionEcheanceDao.findById(id).orElse(null);
    }

    public boolean update(final EtatBCMPrevisionEcheance etatBCMPrevisionEcheance) {
        Optional<EtatBCMPrevisionEcheance> etatBCMPrevisionEcheanceOp = etatBCMPrevisionEcheanceDao.findById(etatBCMPrevisionEcheance.getId());
        if (etatBCMPrevisionEcheanceOp.isPresent()) {
            EtatBCMPrevisionEcheance etatBCMPrevisionEcheanceSaved = etatBCMPrevisionEcheanceOp.get();
            etatBCMPrevisionEcheanceSaved.setBanque(etatBCMPrevisionEcheance.getBanque());
            etatBCMPrevisionEcheanceSaved.setNumCredoc(etatBCMPrevisionEcheance.getNumCredoc());
            etatBCMPrevisionEcheanceSaved.setDevise(etatBCMPrevisionEcheance.getDevise());
            etatBCMPrevisionEcheanceSaved.setMontantEcheance(etatBCMPrevisionEcheance.getMontantEcheance());
            etatBCMPrevisionEcheanceSaved.setDateEcheance(etatBCMPrevisionEcheance.getDateEcheance());
            etatBCMPrevisionEcheanceDao.save(etatBCMPrevisionEcheanceSaved);
            return true;
        }
        return false;
    }

    public StringWriter exportData() throws IOException {
        List<EtatBCMPrevisionEcheance> etatBCMPrevisionEcheances = etatBCMPrevisionEcheanceDao.findAll();
        String[] headers = new String[]{
                "banque", "numCredoc", "date de l'échéance", "montant de l'échéance", "devise",
        };
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(headers)
                .setDelimiter(";")
                .build();
        StringWriter sw = new StringWriter();
        try (final CSVPrinter printer = new CSVPrinter(sw, csvFormat)) {
            etatBCMPrevisionEcheances.forEach(report -> {
                try {
                    printer.printRecord(report.getBanque(), report.getNumCredoc(), report.getDateEcheance(), report.getMontantEcheance(),
                            report.getDevise());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        return sw;
    }
}
