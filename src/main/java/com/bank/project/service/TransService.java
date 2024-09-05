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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
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
    private final TransMapper transMapper;

    private final BenefService benefService;

    private final EnvoyeurService envoyeurService;

    public TransService(BenefService benefService, EnvoyeurService envoyeurService,TransMapper transMapper) {
        this.benefService = benefService;
        this.envoyeurService = envoyeurService;
        this.transMapper = transMapper;
    }



    public List<TransDto> findFiltreTrans(String number, int agence){
        return transMapper.toDto(transDao.findByEnvoyeur_EntelAndEnvoyeur_Enagcode(number,agence));
    }

    public List<TransDto> findTransByBenef(String number){
        return transMapper.toDto(transDao.findByEnvoyeur_EntelOrderByTrcodeDesc(number));
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

//    public TransDto addTrans(TransDto transDto, MultipartFile file){
//
//        Trans trans = transMapper.toModel(transDto);
//
//        Benef benefDto =  benefMapper.toModel(transDto.getBenef());
//        if (benefDto != null){
//            Benef benef = benefService.save(benefDto);
//            trans.setBenef(benef);
//        }
//
//        Envoyeur envoyeurDto = envoyeurMapper.toModel(transDto.getEnvoyeur());
//        if(envoyeurDto != null){
//            Envoyeur envoyeur = envoyeurService.save(envoyeurDto);
//            trans.setEnvoyeur(envoyeur);
//        }
//
//        try{
//            trans.setTRAVIS(file.getBytes());
//        }catch (IOException ex) {
//            throw new RuntimeException(ex);
//        }
//
////        System.out.println(Arrays.toString(trans.getTRAVIS()));
//        return transMapper.toDto(transDao.save(trans));
//
////        return envoyeurMapper.toModel(transDto.getEnvoyeur()); // test les donnees envoyee via request;
//    }

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

//        System.out.println(Arrays.toString(trans.getTRAVIS()));
        return transMapper.toDto(transDao.save(trans));

//        return envoyeurMapper.toModel(transDto.getEnvoyeur()); // test les donnees envoyee via request;
    }


}