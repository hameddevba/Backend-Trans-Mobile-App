package com.bank.project.service;

import com.bank.project.dao.EtatBCMBalanceDetailleeDao;
import com.bank.project.model.EtatBCMBalanceDetaillee;
import com.bank.project.model.EtatBCMBalanceGenerale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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

    public boolean update(final EtatBCMBalanceDetaillee etatBCMBalanceDetaillee) {
        Optional<EtatBCMBalanceDetaillee> etatBCMBalanceDetailleeSavedOp = etatBCMBalanceDetailleeDao.findById(etatBCMBalanceDetaillee.getId());
        if(etatBCMBalanceDetailleeSavedOp.isPresent()){
        EtatBCMBalanceDetaillee etatBCMBalanceDetailleeSaved = etatBCMBalanceDetailleeSavedOp.get();
            etatBCMBalanceDetailleeSaved.setSoldeCrediteur(etatBCMBalanceDetaillee.getSoldeCrediteur());
            etatBCMBalanceDetailleeSaved.setSoldeDebiteur(etatBCMBalanceDetaillee.getSoldeDebiteur());
            etatBCMBalanceDetailleeSaved.setResident(etatBCMBalanceDetaillee.getResident());
            etatBCMBalanceDetailleeSaved.setDateClotureBalance(etatBCMBalanceDetaillee.getDateClotureBalance());
            etatBCMBalanceDetailleeSaved.setCompte(etatBCMBalanceDetaillee.getCompte());
            etatBCMBalanceDetailleeSaved.setIntituleCompteComptable(etatBCMBalanceDetaillee.getIntituleCompteComptable());
            etatBCMBalanceDetailleeSaved.setCompteBancaireClient(etatBCMBalanceDetaillee.getCompteBancaireClient());
            etatBCMBalanceDetailleeSaved.setIntituleCompteBancaire(etatBCMBalanceDetaillee.getIntituleCompteBancaire());
            etatBCMBalanceDetailleeSaved.setActiviteClient(etatBCMBalanceDetaillee.getActiviteClient());
            etatBCMBalanceDetailleeSaved.setSecteurActiviteClient(etatBCMBalanceDetaillee.getSecteurActiviteClient());
            etatBCMBalanceDetailleeSaved.setEstClientApparente(etatBCMBalanceDetaillee.getEstClientApparente());
            etatBCMBalanceDetailleeSaved.setBanque(etatBCMBalanceDetaillee.getBanque());
            etatBCMBalanceDetailleeSaved.setDevise(etatBCMBalanceDetaillee.getDevise());


        etatBCMBalanceDetailleeDao.save(etatBCMBalanceDetailleeSaved);
            return true;
        }
        return false;
    }
}
