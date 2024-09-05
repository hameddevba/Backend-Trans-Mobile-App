package com.bank.project.service;

import com.bank.project.dao.AgenceDao;
import com.bank.project.dto.Agence;
import com.bank.project.dto.AgenceDto;
import com.bank.project.mapper.AgenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenceService {



    private AgenceDao agenceDao;
    @Autowired
    public AgenceService(AgenceDao agenceDao, AgenceMapper agenceMapper) {

        this.agenceDao = agenceDao;
        this.agenceMapper = agenceMapper;
    }

    private AgenceMapper agenceMapper;

    public List<AgenceDto> getAgenceDto(){
        List<Agence> agences = agenceDao.findAll();
        return agenceMapper.toAgenceDto(agences);
    }
}
