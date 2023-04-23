package com.bank.project.controller;

import com.bank.project.dto.EtatBCMBalanceDetailleeDto;
import com.bank.project.mapper.EtatBCMBalanceDetailleeMapper;
import com.bank.project.model.EtatBCMBalanceDetaillee;
import com.bank.project.service.EtatBCMBalanceDetailleeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/etatBCM_BalanceDetaillees", produces = MediaType.APPLICATION_JSON_VALUE)
public class EtatBCMBalanceDetailleeController {
    private final EtatBCMBalanceDetailleeService etatBCMBalanceDetailleeService;

    private final EtatBCMBalanceDetailleeMapper mapper;

    public EtatBCMBalanceDetailleeController(
            @Autowired final EtatBCMBalanceDetailleeService etatBCMBalanceDetailleeService, @Autowired EtatBCMBalanceDetailleeMapper etatBCMBalanceDetailleeMapper) {
        this.etatBCMBalanceDetailleeService = etatBCMBalanceDetailleeService;
        this.mapper = etatBCMBalanceDetailleeMapper;
    }

    @GetMapping
    public ResponseEntity<List<EtatBCMBalanceDetailleeDto>> getAllEtatBCMBalanceDetaillees() {
        List<EtatBCMBalanceDetaillee> etatBCMBalanceDetaillees = etatBCMBalanceDetailleeService.findAll();
        return ResponseEntity.ok(mapper.toDto(etatBCMBalanceDetaillees));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtatBCMBalanceDetailleeDto> getEtatBCMBalanceDetaillee(
            @PathVariable final Long id) {
        EtatBCMBalanceDetaillee etatBCMBalanceDetaillee = etatBCMBalanceDetailleeService.findById(id);
        return ResponseEntity.ok(mapper.toDto(etatBCMBalanceDetaillee));
    }


}
