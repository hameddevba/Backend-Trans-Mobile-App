package com.bank.project.controller;

import com.bank.project.dto.AgenceDto;
import com.bank.project.service.AgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ="/api/agences")
//@PreAuthorize("hasRole('ADMIN')")
public class AgenceController {

    @Autowired
    private AgenceService agenceService;


    @GetMapping
    public List<AgenceDto> getAllAgence(){
        return agenceService.getAgenceDto();
    }

}
