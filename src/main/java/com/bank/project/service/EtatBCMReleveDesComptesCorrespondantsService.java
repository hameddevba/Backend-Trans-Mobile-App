package com.bank.project.service;

import com.bank.project.dao.EtatBCMReleveDesComptesCorrespondantsDao;
import com.bank.project.model.EtatBCMReleveDesComptesCorrespondants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EtatBCMReleveDesComptesCorrespondantsService {
    @Autowired
    private EtatBCMReleveDesComptesCorrespondantsDao etatBCMReleveDesComptesCorrespondantsDao;


    public List<EtatBCMReleveDesComptesCorrespondants> findAll() {
        return etatBCMReleveDesComptesCorrespondantsDao.findAll(Sort.by("id"));
    }

    public EtatBCMReleveDesComptesCorrespondants findById(final Long id) {
        return etatBCMReleveDesComptesCorrespondantsDao.findById(id).orElse(null);
    }
    public boolean update(final EtatBCMReleveDesComptesCorrespondants etatBCMReleveDesComptesCorrespondant) {
        Optional<EtatBCMReleveDesComptesCorrespondants> etatBCMReleveDesComptesCorrespondantsOp = etatBCMReleveDesComptesCorrespondantsDao.findById(etatBCMReleveDesComptesCorrespondant.getId());
        if(etatBCMReleveDesComptesCorrespondantsOp.isPresent()){
            EtatBCMReleveDesComptesCorrespondants etatBCMReleveDesComptesCorrespondantsSaved = etatBCMReleveDesComptesCorrespondantsOp.get();
            etatBCMReleveDesComptesCorrespondantsSaved.setBanque(etatBCMReleveDesComptesCorrespondantsSaved.getBanque());
            etatBCMReleveDesComptesCorrespondantsSaved.setNomCorrespondant(etatBCMReleveDesComptesCorrespondantsSaved.getNomCorrespondant());
            etatBCMReleveDesComptesCorrespondantsSaved.setNumCompte(etatBCMReleveDesComptesCorrespondantsSaved.getNumCompte());
            etatBCMReleveDesComptesCorrespondantsSaved.setDevise(etatBCMReleveDesComptesCorrespondantsSaved.getDevise());
            etatBCMReleveDesComptesCorrespondantsSaved.setDateApCloture(etatBCMReleveDesComptesCorrespondantsSaved.getDateApCloture());
            etatBCMReleveDesComptesCorrespondantsSaved.setSoldeDebutJournee(etatBCMReleveDesComptesCorrespondantsSaved.getSoldeFinJournee());
            etatBCMReleveDesComptesCorrespondantsSaved.setTotalMvtsDebiteursJournee(etatBCMReleveDesComptesCorrespondantsSaved.getTotalMvtsDebiteursJournee());
            etatBCMReleveDesComptesCorrespondantsSaved.setTotalMvtsCrediteurs(etatBCMReleveDesComptesCorrespondantsSaved.getTotalMvtsCrediteurs());
            etatBCMReleveDesComptesCorrespondantsSaved.setSoldeFinJournee(etatBCMReleveDesComptesCorrespondantsSaved.getSoldeFinJournee());
            etatBCMReleveDesComptesCorrespondantsDao.save(etatBCMReleveDesComptesCorrespondantsSaved);
            return true;
        }
        return false;
    }

}
