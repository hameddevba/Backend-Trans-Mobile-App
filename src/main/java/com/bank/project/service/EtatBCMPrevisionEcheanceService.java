package com.bank.project.service;

import com.bank.project.dao.EtatBCMPrevisionEcheanceDao;
import com.bank.project.model.EtatBCMPrevisionEcheance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EtatBCMPrevisionEcheanceService {
    @Autowired
    private EtatBCMPrevisionEcheanceDao etatBCMPrevisionEcheanceDao;


    public List<EtatBCMPrevisionEcheance> findAll() {
        return etatBCMPrevisionEcheanceDao.findAll(Sort.by("id"));
    }

    public EtatBCMPrevisionEcheance findById(final Long id) {
        return etatBCMPrevisionEcheanceDao.findById(id).get();
    }

}
