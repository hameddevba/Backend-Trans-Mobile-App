package com.bank.project.controller;

import com.bank.project.dto.EtatBCMFluxEntrantsDto;
import com.bank.project.mapper.EtatBCMFluxEntrantsMapper;
import com.bank.project.model.EtatBCMFluxEntrants;
import com.bank.project.service.EtatBCFluxEntrantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/etatBCM_Flux_Entrants", produces = MediaType.APPLICATION_JSON_VALUE)
public class EtatBCMFluxEntrantsController {
    private final EtatBCFluxEntrantsService etatBCFluxEntrantsService;

    private final EtatBCMFluxEntrantsMapper mapper;

    public EtatBCMFluxEntrantsController(
            @Autowired final EtatBCFluxEntrantsService etatBCFluxEntrantsService, @Autowired EtatBCMFluxEntrantsMapper etatBCMFluxEntrantsMapper) {
        this.etatBCFluxEntrantsService = etatBCFluxEntrantsService;
        this.mapper = etatBCMFluxEntrantsMapper;
    }

    @GetMapping
    public ResponseEntity<List<EtatBCMFluxEntrantsDto>> getAllEtatBCMFluxEntrants() {
        List<EtatBCMFluxEntrants> etatBCMFluxEntrants = etatBCFluxEntrantsService.findAll();
        return ResponseEntity.ok(mapper.toDto(etatBCMFluxEntrants));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtatBCMFluxEntrantsDto> getEtatBCMFluxSortant(
            @PathVariable final Long id) {
        EtatBCMFluxEntrants etatBCMFluxEntrants = etatBCFluxEntrantsService.findById(id);
        return ResponseEntity.ok(mapper.toDto(etatBCMFluxEntrants));
    }


}
