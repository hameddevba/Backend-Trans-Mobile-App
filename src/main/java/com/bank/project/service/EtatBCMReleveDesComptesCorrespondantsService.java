package com.bank.project.service;

import com.bank.project.dao.EtatBCMReleveDesComptesCorrespondantsDao;
import com.bank.project.model.EtatBCMReleveDesComptesCorrespondants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EtatBCMReleveDesComptesCorrespondantsService {
    @Autowired
    private EtatBCMReleveDesComptesCorrespondantsDao etatBCMReleveDesComptesCorrespondantsDao;


    public List<EtatBCMReleveDesComptesCorrespondants> findAll() {
        return etatBCMReleveDesComptesCorrespondantsDao.findAll(Sort.by("id"));
    }

    public EtatBCMReleveDesComptesCorrespondants findById(final Long id) {
        return etatBCMReleveDesComptesCorrespondantsDao.findById(id).get();
    }

}
