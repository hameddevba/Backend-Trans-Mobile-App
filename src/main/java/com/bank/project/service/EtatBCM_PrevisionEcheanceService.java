package com.bank.project.service;

import com.bank.project.dao.EtatBCM_PrevisionEcheanceDao;
import com.bank.project.model.EtatBCM_PrevisionEcheance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EtatBCM_PrevisionEcheanceService {
    @Autowired
    private EtatBCM_PrevisionEcheanceDao etatBCM_PrevisionEcheanceDao;


    public List<EtatBCM_PrevisionEcheance> findAll() {
        return etatBCM_PrevisionEcheanceDao.findAll(Sort.by("id"));
    }

    public EtatBCM_PrevisionEcheance findById(final Long id) {
        return etatBCM_PrevisionEcheanceDao.findById(id).get();
    }

}
