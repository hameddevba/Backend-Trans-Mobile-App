package com.bank.project.service;

import com.bank.project.dao.EtatBCM_ReleveDesComptesCorrespondantsDao;
import com.bank.project.model.EtatBCM_ReleveDesComptesCorrespondants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EtatBCM_ReleveDesComptesCorrespondantsService {
    @Autowired
    private EtatBCM_ReleveDesComptesCorrespondantsDao etatBCM_ReleveDesComptesCorrespondantsDao;


    public List<EtatBCM_ReleveDesComptesCorrespondants> findAll() {
        return etatBCM_ReleveDesComptesCorrespondantsDao.findAll(Sort.by("id"));
    }

    public EtatBCM_ReleveDesComptesCorrespondants findById(final Long id) {
        return etatBCM_ReleveDesComptesCorrespondantsDao.findById(id).get();
    }

}
