package com.bank.project.service;

import com.bank.project.dao.BenefDao;
import com.bank.project.model.Benef;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BenefService {
    @Autowired
    private BenefDao benefDao;

    public Benef save(Benef benef) {
        return benefDao.save(benef);
    }
    public List<Benef> findAll() {
        return benefDao.findAll();
    }
}
