package com.bank.project.controller;

import com.bank.project.dto.BalanceGeneraleDto;
import com.bank.project.mapper.EtatBCMBalanceGeneraleMapper;
import com.bank.project.mapper.EtatBCMBalanceGeneralePublishMapper;
import com.bank.project.model.EtatBCMBalanceGenerale;
import com.bank.project.service.EtatBCMBalanceGeneraleService;
import com.bank.project.service.PublishService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/etatBCMBalanceGenerales", produces = MediaType.APPLICATION_JSON_VALUE)
public class EtatBCMBalanceGeneraleController {
    private final EtatBCMBalanceGeneraleService etatBCMBalanceGeneraleService;
    private final PublishService publishService;

    private final EtatBCMBalanceGeneraleMapper mapper;
    private final EtatBCMBalanceGeneralePublishMapper publishMapper;

    public EtatBCMBalanceGeneraleController(
            final EtatBCMBalanceGeneraleService etatBCMBalanceGeneraleService, final PublishService publishService,
            final EtatBCMBalanceGeneraleMapper etatBCMBalanceGeneraleMapper,final EtatBCMBalanceGeneralePublishMapper etatBCMBalanceGeneralePublishMapper) {
        this.etatBCMBalanceGeneraleService = etatBCMBalanceGeneraleService;
        this.publishService = publishService;
        this.mapper = etatBCMBalanceGeneraleMapper;
        this.publishMapper = etatBCMBalanceGeneralePublishMapper;
    }

    @GetMapping
    public ResponseEntity<List<BalanceGeneraleDto>> getAllEtatBCMBalanceGenerales() {
        List<EtatBCMBalanceGenerale> etatBCMBalanceGenerales = etatBCMBalanceGeneraleService.findAll();
        return ResponseEntity.ok(mapper.toDto(etatBCMBalanceGenerales));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BalanceGeneraleDto> getEtatBCMBalanceGenerale(
            @PathVariable final Long id) {
        EtatBCMBalanceGenerale etatBCMBalanceGenerale = etatBCMBalanceGeneraleService.findById(id);
        return ResponseEntity.ok(mapper.toDto(etatBCMBalanceGenerale));
    }

    @PostMapping("/publish")
    public ResponseEntity<Boolean> publish() {
        List<EtatBCMBalanceGenerale> etatBCMBalanceGenerales = etatBCMBalanceGeneraleService.findAll();
        boolean published = publishService.publishEtatGenerale(publishMapper.toDto(etatBCMBalanceGenerales));
        return ResponseEntity.ok(published);
    }

    @PutMapping
    public ResponseEntity<Boolean> update(@RequestBody BalanceGeneraleDto etatBCMBalanceGenerale) {
        return ResponseEntity.ok(etatBCMBalanceGeneraleService.update(this.mapper.toModel(etatBCMBalanceGenerale)));
    }
}
