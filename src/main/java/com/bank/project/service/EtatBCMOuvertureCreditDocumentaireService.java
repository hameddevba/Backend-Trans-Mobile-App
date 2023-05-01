package com.bank.project.service;

import com.bank.project.dao.EtatBCMOuvertureCreditDocumentaireDao;
import com.bank.project.model.EtatBCMOuvertureCreditDocumentaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EtatBCMOuvertureCreditDocumentaireService {
    @Autowired
    private EtatBCMOuvertureCreditDocumentaireDao etatBCMOuvertureCreditDocumentaireDao;


    public List<EtatBCMOuvertureCreditDocumentaire> findAll() {
        return etatBCMOuvertureCreditDocumentaireDao.findAll(Sort.by("id"));
    }

    public EtatBCMOuvertureCreditDocumentaire findById(final Long id) {
        return etatBCMOuvertureCreditDocumentaireDao.findById(id).orElse(null);
    }

    public boolean update(final EtatBCMOuvertureCreditDocumentaire etatBCMOuvertureCreditDocumentaire) {
        Optional<EtatBCMOuvertureCreditDocumentaire> etatBCMOuvertureCreditDocumentaireSavedOp = etatBCMOuvertureCreditDocumentaireDao.findById(etatBCMOuvertureCreditDocumentaire.getId());
        if(etatBCMOuvertureCreditDocumentaireSavedOp.isPresent()){
            EtatBCMOuvertureCreditDocumentaire etatBCMOuvertureCreditDocumentaireSaved = etatBCMOuvertureCreditDocumentaireSavedOp.get();
            etatBCMOuvertureCreditDocumentaireSaved.setBanque(etatBCMOuvertureCreditDocumentaire.getBanque());
            etatBCMOuvertureCreditDocumentaireSaved.setDateOuverture(etatBCMOuvertureCreditDocumentaire.getDateOuverture());
            etatBCMOuvertureCreditDocumentaireSaved.setBeneficiaire(etatBCMOuvertureCreditDocumentaire.getBeneficiaire());
            etatBCMOuvertureCreditDocumentaireSaved.setMontantOuverture(etatBCMOuvertureCreditDocumentaire.getMontantOuverture());
            etatBCMOuvertureCreditDocumentaireSaved.setDevise(etatBCMOuvertureCreditDocumentaire.getDevise());
            etatBCMOuvertureCreditDocumentaireSaved.setNomCorrespondant(etatBCMOuvertureCreditDocumentaire.getNomCorrespondant());
            etatBCMOuvertureCreditDocumentaireSaved.setNomDonneurOrdre(etatBCMOuvertureCreditDocumentaire.getNomDonneurOrdre());
            etatBCMOuvertureCreditDocumentaireSaved.setNumCredoc(etatBCMOuvertureCreditDocumentaire.getNumCredoc());
            etatBCMOuvertureCreditDocumentaireSaved.setProduit(etatBCMOuvertureCreditDocumentaire.getProduit());
            etatBCMOuvertureCreditDocumentaireSaved.setDeposite(etatBCMOuvertureCreditDocumentaire.getDeposite());
            etatBCMOuvertureCreditDocumentaireSaved.setPays(etatBCMOuvertureCreditDocumentaire.getPays());


            etatBCMOuvertureCreditDocumentaireDao.save(etatBCMOuvertureCreditDocumentaireSaved);
            return true;
        }
        return false;
    }
}
