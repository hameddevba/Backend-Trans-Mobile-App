package com.bank.project.controller;

import com.bank.project.dto.BalanceDetailleeDto;
import com.bank.project.dto.BalanceGeneraleDto;
import com.bank.project.mapper.BalanceDetailleeMapper;
import com.bank.project.mapper.BalanceDetailleePublishMapper;
import com.bank.project.mapper.EtatBCMBalanceGeneralePublishMapper;
import com.bank.project.model.EtatBCMBalanceDetaillee;
import com.bank.project.model.EtatBCMBalanceGenerale;
import com.bank.project.service.EtatBCMBalanceDetailleeService;
import com.bank.project.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/etatBCMBalanceDetaillees", produces = MediaType.APPLICATION_JSON_VALUE)
public class EtatBCMBalanceDetailleeController {
    private final EtatBCMBalanceDetailleeService etatBCMBalanceDetailleeService;

    private final BalanceDetailleeMapper mapper;

    private final PublishService publishService;

    private final BalanceDetailleePublishMapper publishMapper;

    public EtatBCMBalanceDetailleeController(EtatBCMBalanceDetailleeService etatBCMBalanceDetailleeService, BalanceDetailleeMapper mapper, PublishService publishService, BalanceDetailleePublishMapper publishMapper) {
        this.etatBCMBalanceDetailleeService = etatBCMBalanceDetailleeService;
        this.mapper = mapper;
        this.publishService = publishService;
        this.publishMapper = publishMapper;
    }


    @GetMapping
    public ResponseEntity<List<BalanceDetailleeDto>> getAllEtatBCMBalanceDetaillees() {
        List<EtatBCMBalanceDetaillee> etatBCMBalanceDetaillees = etatBCMBalanceDetailleeService.findAll();
        return ResponseEntity.ok(mapper.toDto(etatBCMBalanceDetaillees));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BalanceDetailleeDto> getEtatBCMBalanceDetaillee(
            @PathVariable final Long id) {
        EtatBCMBalanceDetaillee etatBCMBalanceDetaillee = etatBCMBalanceDetailleeService.findById(id);
        return ResponseEntity.ok(mapper.toDto(etatBCMBalanceDetaillee));
    }

    @PostMapping("/publish")
    public ResponseEntity<Boolean> publish() {
        List<EtatBCMBalanceDetaillee> etatBCMBalanceDetaillees = etatBCMBalanceDetailleeService.findAll();
        boolean published = publishService.publishEtatBalanceDetaillee(publishMapper.toDto(etatBCMBalanceDetaillees));
        return ResponseEntity.ok(published);
    }

    @PutMapping
    public ResponseEntity<Boolean> update(@RequestBody BalanceDetailleeDto etatBCMBalanceDetaillee) {
        return ResponseEntity.ok(etatBCMBalanceDetailleeService.update(this.mapper.toModel(etatBCMBalanceDetaillee)));
    }

}
