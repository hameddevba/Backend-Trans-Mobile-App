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
import java.util.Optional;

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

    public List<TransDto> findTransByEnv(String number){
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

    public void uploadFile(Long transCode, MultipartFile file){

        Optional<Trans> trans = transDao.findById(transCode);


        try{
            if(trans.isPresent()){
                trans.get().setTRAVIS(file.getBytes());
                trans.get().setTRVALIDAN("3");
            }
        }catch (IOException ex) {
            throw new RuntimeException(ex);
        }

//        System.out.println(Arrays.toString(trans.getTRAVIS()));
        transMapper.toDto(transDao.save(trans.get()));
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

//        System.out.println(Arrays.toString(trans.getTRAVIS()));
        return transMapper.toDto(transDao.save(trans));

//        return envoyeurMapper.toModel(transDto.getEnvoyeur()); // test les donnees envoyee via request;
    }


}