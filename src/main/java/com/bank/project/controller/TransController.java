package com.bank.project.controller;

import com.bank.project.dto.TransDto;
import com.bank.project.mapper.TransMapper;
import com.bank.project.model.Trans;
import com.bank.project.service.TransService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value ="/api/trans")
//@PreAuthorize("hasRole('ADMIN')")
public class TransController {


    @Autowired
    TransService transService;
    @Autowired
    TransMapper mapper;

    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping
    public List<TransDto> findAll(){
        List<Trans> transes = transService.find();
          return mapper.toDto(transes);
    }

    @GetMapping("filtre/{number}/{agence}")
    public List<TransDto> findFiltreTrans(@PathVariable String number, @PathVariable int agence){
       return transService.findFiltreTrans(number,agence);
    }
    @GetMapping("benef/{number}")
    public List<TransDto> findTransByBenef(@PathVariable String number){
        return transService.findTransByBenef(number);
    }

    @GetMapping("/{id}")
    public TransDto findById(@PathVariable Long id){
        Trans trans = transService.findById(id);
        return mapper.toDto(trans);
    }
//    @PostMapping("/changetrans")
//    public TransDto save(@RequestBody TransDto transDto) {
//        Trans trans = transService.save(this.mapper.toModel(transDto));
//        return mapper.toDto(trans);
//    }

//    @PostMapping("/changetrans")
//    public TransDto save(@RequestParam("data") String stransDto, @RequestParam("file") MultipartFile file) throws JsonProcessingException {
//        TransDto transDto = objectMapper.readValue(stransDto, TransDto.class);
//        return transService.addTrans(transDto,file);
//    }
    @PostMapping("/changetrans")
    public TransDto save(@RequestParam("data") String stransDto) throws JsonProcessingException {
        TransDto transDto = objectMapper.readValue(stransDto, TransDto.class);
        return transService.addTrans(transDto);
    }
    
}
