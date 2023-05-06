package com.bank.project.service;

import com.bank.project.dao.EtatBCMPrevisionEcheanceDao;
import com.bank.project.model.EtatBCMPrevisionEcheance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EtatBCMPrevisionEcheanceService {
    @Autowired
    private EtatBCMPrevisionEcheanceDao etatBCMPrevisionEcheanceDao;


    public List<EtatBCMPrevisionEcheance> findAll() {
        return etatBCMPrevisionEcheanceDao.findAll(Sort.by("id"));
    }
    public Page<EtatBCMPrevisionEcheance> findEchantillon(int page, int size) {
        return etatBCMPrevisionEcheanceDao.findAll(PageRequest.of(page, size,Sort.by("id")));
    }
    public EtatBCMPrevisionEcheance findById(final Long id) {
        return etatBCMPrevisionEcheanceDao.findById(id).orElse(null);
    }

    public boolean update(final EtatBCMPrevisionEcheance etatBCMPrevisionEcheance) {
        Optional<EtatBCMPrevisionEcheance> etatBCMPrevisionEcheanceOp = etatBCMPrevisionEcheanceDao.findById(etatBCMPrevisionEcheance.getId());
        if(etatBCMPrevisionEcheanceOp.isPresent()){
            EtatBCMPrevisionEcheance etatBCMPrevisionEcheanceSaved = etatBCMPrevisionEcheanceOp.get();
            etatBCMPrevisionEcheanceSaved.setBanque(etatBCMPrevisionEcheance.getBanque());
            etatBCMPrevisionEcheanceSaved.setNumCredoc(etatBCMPrevisionEcheance.getNumCredoc());
            etatBCMPrevisionEcheanceSaved.setDevise(etatBCMPrevisionEcheance.getDevise());
            etatBCMPrevisionEcheanceSaved.setMontantEcheance(etatBCMPrevisionEcheance.getMontantEcheance());
            etatBCMPrevisionEcheanceSaved.setDateEcheance(etatBCMPrevisionEcheance.getDateEcheance());
            etatBCMPrevisionEcheanceDao.save(etatBCMPrevisionEcheanceSaved);
            return true;
        }
        return false;
    }

}
