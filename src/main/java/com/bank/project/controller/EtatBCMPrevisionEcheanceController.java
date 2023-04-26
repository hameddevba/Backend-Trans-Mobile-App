package com.bank.project.controller;

import com.bank.project.dto.PrevisionEcheanceDto;
import com.bank.project.mapper.PrevisionEcheanceMapper;
import com.bank.project.mapper.PrevisionEcheancePublishMapper;
import com.bank.project.model.EtatBCMPrevisionEcheance;
import com.bank.project.service.EtatBCMPrevisionEcheanceService;
import com.bank.project.service.PublishService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/etatBCM_PrevisionEcheance", produces = MediaType.APPLICATION_JSON_VALUE)
public class EtatBCMPrevisionEcheanceController {
    private final EtatBCMPrevisionEcheanceService etatBCMPrevisionEcheanceService;
    private final PublishService publishService;
    private final PrevisionEcheanceMapper mapper;
    private final PrevisionEcheancePublishMapper publishMapper;

    public EtatBCMPrevisionEcheanceController(EtatBCMPrevisionEcheanceService etatBCMPrevisionEcheanceService, PublishService publishService,
                                              PrevisionEcheanceMapper mapper, PrevisionEcheancePublishMapper publishMapper) {
        this.etatBCMPrevisionEcheanceService = etatBCMPrevisionEcheanceService;
        this.publishService = publishService;
        this.mapper = mapper;
        this.publishMapper = publishMapper;
    }

    @GetMapping
    public ResponseEntity<List<PrevisionEcheanceDto>> getAllEtatBCMPrevisionEcheance() {
        List<EtatBCMPrevisionEcheance> etatBCMPrevisionEcheance = etatBCMPrevisionEcheanceService.findAll();
        return ResponseEntity.ok(mapper.toDto(etatBCMPrevisionEcheance));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrevisionEcheanceDto> getEtatBCMFluxSortant(
            @PathVariable final Long id) {
        EtatBCMPrevisionEcheance etatBCMPrevisionEcheance = etatBCMPrevisionEcheanceService.findById(id);
        return ResponseEntity.ok(mapper.toDto(etatBCMPrevisionEcheance));
    }

    @PostMapping("/publish")
    public ResponseEntity<Boolean> publish() {
        List<EtatBCMPrevisionEcheance> etatBCMPrevisionEcheances = etatBCMPrevisionEcheanceService.findAll();
        boolean published = publishService.publishEtatBCMPrevisionEcheance(publishMapper.toDto(etatBCMPrevisionEcheances));
        return ResponseEntity.ok(published);
    }

    @PutMapping
    public ResponseEntity<Boolean> update(@RequestBody PrevisionEcheanceDto previsionEcheanceDto) {
        return ResponseEntity.ok(etatBCMPrevisionEcheanceService.update(this.mapper.toModel(previsionEcheanceDto)));
    }
}
