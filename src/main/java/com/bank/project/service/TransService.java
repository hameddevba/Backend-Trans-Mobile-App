package com.bank.project.service;

import com.bank.project.dao.TransDao;
import com.bank.project.dto.TransDto;
import com.bank.project.mapper.BenefMapper;
import com.bank.project.mapper.EnvoyeurMapper;
import com.bank.project.mapper.TransMapper;
import com.bank.project.model.Benef;
import com.bank.project.model.Envoyeur;
import com.bank.project.model.Trans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransService {
    @Autowired
    private TransDao transDao;
    @Autowired
    private BenefMapper benefMapper;
    @Autowired
    private EnvoyeurMapper envoyeurMapper;

    @Autowired
    TransMapper transMapper;

    private final BenefService benefService;

    private final EnvoyeurService envoyeurService;

    public TransService(BenefService benefService, EnvoyeurService envoyeurService) {
        this.benefService = benefService;
        this.envoyeurService = envoyeurService;
    }


    public List<Trans> find() {
        return transDao.findAll();
    }

    public Trans findById(long id) {
        return transDao.findById(id).orElse(null);
    }

    public Trans save(Trans trans) {
        return transDao.save(trans);
    }

    public TransDto addTrans(TransDto transDto){

        Trans trans = transMapper.toModel(transDto);

        Benef benefDto =  benefMapper.toModel(transDto.getBenef());
        if (benefDto != null){
            Benef benef = benefService.save(benefDto);
            trans.setBenef(benef);
        }

        Envoyeur envoyeurDto = envoyeurMapper.toModel(transDto.getEnvoyeur());
        if(envoyeurDto != null){
            Envoyeur envoyeur = envoyeurService.save(envoyeurDto);
            trans.setEnvoyeur(envoyeur);
        }


        return transMapper.toDto(transDao.save(trans));

//        return envoyeurMapper.toModel(transDto.getEnvoyeur()); // test les donnees envoyee via request;
    }

}
