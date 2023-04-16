package com.bank.project.controller;

import com.bank.project.dto.EtatBCM_BalanceDetailleeDto;
import com.bank.project.mapper.EtatBCM_BalanceDetailleeMapper;
import com.bank.project.model.EtatBCM_BalanceDetaillee;
import com.bank.project.service.EtatBCM_BalanceDetailleeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/etatBCM_BalanceDetaillees", produces = MediaType.APPLICATION_JSON_VALUE)
public class EtatBCM_BalanceDetailleeController {
    private final EtatBCM_BalanceDetailleeService etatBCM_BalanceDetailleeService;

    private final EtatBCM_BalanceDetailleeMapper mapper;

    public EtatBCM_BalanceDetailleeController(
            @Autowired final EtatBCM_BalanceDetailleeService etatBCM_BalanceDetailleeService, @Autowired EtatBCM_BalanceDetailleeMapper etatBCM_BalanceDetailleeMapper) {
        this.etatBCM_BalanceDetailleeService = etatBCM_BalanceDetailleeService;
        this.mapper = etatBCM_BalanceDetailleeMapper;
    }

    @GetMapping
    public ResponseEntity<List<EtatBCM_BalanceDetailleeDto>> getAllEtatBCM_BalanceDetaillees() {
        List<EtatBCM_BalanceDetaillee> etatBCM_BalanceDetaillees = etatBCM_BalanceDetailleeService.findAll();
        return ResponseEntity.ok(mapper.toDto(etatBCM_BalanceDetaillees));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtatBCM_BalanceDetailleeDto> getEtatBCM_BalanceDetaillee(
            @PathVariable final Long id) {
        EtatBCM_BalanceDetaillee etatBCM_BalanceDetaillee = etatBCM_BalanceDetailleeService.findById(id);
        return ResponseEntity.ok(mapper.toDto(etatBCM_BalanceDetaillee));
    }


}
