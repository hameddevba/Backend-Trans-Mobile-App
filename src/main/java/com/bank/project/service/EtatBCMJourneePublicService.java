package com.bank.project.service;

import com.bank.project.dao.EtatBCMBalanceGeneraleDao;
import com.bank.project.dao.EtatBCMJourneePublicDao;
import com.bank.project.model.EtatBCMBalanceGenerale;
import com.bank.project.model.EtatBCMJourneePublic;
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
public class EtatBCMJourneePublicService {
    @Autowired
    private EtatBCMJourneePublicDao etatBCMJourneePublicDao;



    public List<EtatBCMJourneePublic> findAll() {
        return etatBCMJourneePublicDao.findAll();
    }
    public EtatBCMJourneePublic findById(final Long id) {
        return etatBCMJourneePublicDao.findById(id).orElse(null);
    }

}
