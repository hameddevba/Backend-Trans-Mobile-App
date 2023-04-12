package com.bank.project.service;

import com.bank.project.dao.EtatBCM_BalanceDetailleeDao;
import com.bank.project.model.EtatBCM_BalanceDetaillee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EtatBCM_BalanceDetailleeService {
    @Autowired
    private EtatBCM_BalanceDetailleeDao etatBCM_BalanceDetailleeDao;

    public List<EtatBCM_BalanceDetaillee> findAll() {
        return etatBCM_BalanceDetailleeDao.findAll(Sort.by("id"));
    }

    public EtatBCM_BalanceDetaillee findById(final Long id) {
        return etatBCM_BalanceDetailleeDao.findById(id).get();
    }

}
