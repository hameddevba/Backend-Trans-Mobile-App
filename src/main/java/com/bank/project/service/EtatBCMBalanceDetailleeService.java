package com.bank.project.service;

import com.bank.project.dao.EtatBCMBalanceDetailleeDao;
import com.bank.project.model.EtatBCMBalanceDetaillee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EtatBCMBalanceDetailleeService {
    @Autowired
    private EtatBCMBalanceDetailleeDao etatBCMBalanceDetailleeDao;

    public List<EtatBCMBalanceDetaillee> findAll() {
        return etatBCMBalanceDetailleeDao.findAll(Sort.by("id"));
    }

    public EtatBCMBalanceDetaillee findById(final Long id) {
        return etatBCMBalanceDetailleeDao.findById(id).get();
    }

}
