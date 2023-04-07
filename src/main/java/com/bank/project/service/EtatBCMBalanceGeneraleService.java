package com.bank.project.service;

import java.util.List;

import com.bank.project.dao.EtatBCMBalanceGeneraleDao;
import com.bank.project.model.EtatBCMBalanceGenerale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class EtatBCMBalanceGeneraleService {
    @Autowired
    private EtatBCMBalanceGeneraleDao etatBCMBalanceGeneraleDao;

    public List<EtatBCMBalanceGenerale> findAll() {
        return etatBCMBalanceGeneraleDao.findAll(Sort.by("id"));
    }

    public EtatBCMBalanceGenerale findById(final Long id) {
        return etatBCMBalanceGeneraleDao.findById(id).get();
    }

}
