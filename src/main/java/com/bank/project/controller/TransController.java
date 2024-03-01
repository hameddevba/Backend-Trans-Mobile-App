package com.bank.project.controller;

import com.bank.project.dto.TransDto;
import com.bank.project.mapper.TransMapper;
import com.bank.project.model.Trans;
import com.bank.project.service.TransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/api/trans")
//@PreAuthorize("hasRole('ADMIN')")
public class TransController {


    @Autowired
    TransService transService;
    @Autowired
    TransMapper mapper;

    @GetMapping
    public List<TransDto> findAll(){
        List<Trans> transes = transService.find();
          return mapper.toDto(transes);
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

    @PostMapping("/changetrans")
    public TransDto save(@RequestBody TransDto transDto) {
        return transService.addTrans(transDto);
    }
    
}
