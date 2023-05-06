package com.bank.project.service;

import com.bank.project.dao.EtatBCMFluxEntrantsDao;
import com.bank.project.model.EtatBCMFluxEntrants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EtatBCFluxEntrantsService {
    @Autowired
    private EtatBCMFluxEntrantsDao etatBCMFluxEntrantsDao;


    public List<EtatBCMFluxEntrants> findAll() {
        return etatBCMFluxEntrantsDao.findAll(Sort.by("id"));
    }
    public Page<EtatBCMFluxEntrants> findEchantillon(int page, int size) {
        return etatBCMFluxEntrantsDao.findAll(PageRequest.of(page, size,Sort.by("id")));
    }
    public EtatBCMFluxEntrants findById(final Long id) {
        return etatBCMFluxEntrantsDao.findById(id).orElse(null);
    }

    public boolean update(final EtatBCMFluxEntrants etatBCMFluxEntrants) {
        Optional<EtatBCMFluxEntrants> etatBCMFluxEntrantSavedOp = etatBCMFluxEntrantsDao.findById(etatBCMFluxEntrants.getId());
        if(etatBCMFluxEntrantSavedOp.isPresent()){
            EtatBCMFluxEntrants etatBCMFluxEntrantSaved = etatBCMFluxEntrantSavedOp.get();
            etatBCMFluxEntrantSaved.setBanque(etatBCMFluxEntrants.getBanque());
            etatBCMFluxEntrantSaved.setDevise(etatBCMFluxEntrants.getDevise());
            etatBCMFluxEntrantSaved.setReferenceTransaction(etatBCMFluxEntrants.getReferenceTransaction());
            etatBCMFluxEntrantSaved.setDateTransaction(etatBCMFluxEntrants.getDateTransaction());
            etatBCMFluxEntrantSaved.setTypeSwfit(etatBCMFluxEntrants.getTypeSwfit());
            etatBCMFluxEntrantSaved.setModeReglement(etatBCMFluxEntrants.getModeReglement());
            etatBCMFluxEntrantSaved.setMontantTransaction(etatBCMFluxEntrants.getMontantTransaction());
            etatBCMFluxEntrantSaved.setTauxDeChange(etatBCMFluxEntrants.getTauxDeChange());
            etatBCMFluxEntrantSaved.setNomDonneurOrdre(etatBCMFluxEntrants.getNomDonneurOrdre());
            etatBCMFluxEntrantSaved.setNifNni(etatBCMFluxEntrants.getNifNni());
            etatBCMFluxEntrantSaved.setBeneficiaire(etatBCMFluxEntrants.getBeneficiaire());
            etatBCMFluxEntrantSaved.setProduit(etatBCMFluxEntrants.getProduit());
            etatBCMFluxEntrantSaved.setNatureEconomique(etatBCMFluxEntrants.getNatureEconomique());
            etatBCMFluxEntrantSaved.setPays(etatBCMFluxEntrants.getPays());
            etatBCMFluxEntrantsDao.save(etatBCMFluxEntrantSaved);
            return true;
        }
        return false;
    }
}
