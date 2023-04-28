package com.bank.project.controller;

import com.bank.project.dto.EtatBCMFluxEntrantsDto;
import com.bank.project.mapper.EtatBCMFluxEntrantsMapper;
import com.bank.project.mapper.EtatBCMFluxEntrantsPublishMapper;
import com.bank.project.model.EtatBCMFluxEntrants;
import com.bank.project.service.EtatBCFluxEntrantsService;
import com.bank.project.service.PublishService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/etatBCM_Flux_Entrants", produces = MediaType.APPLICATION_JSON_VALUE)
public class EtatBCMFluxEntrantsController {
    private final EtatBCFluxEntrantsService etatBCFluxEntrantsService;

    private final EtatBCMFluxEntrantsMapper mapper;
    private final EtatBCMFluxEntrantsPublishMapper publishMapper;
    private final PublishService publishService;

    public EtatBCMFluxEntrantsController(EtatBCFluxEntrantsService etatBCFluxEntrantsService, EtatBCMFluxEntrantsMapper mapper,
                                         EtatBCMFluxEntrantsPublishMapper publishMapper, PublishService publishService) {
        this.etatBCFluxEntrantsService = etatBCFluxEntrantsService;
        this.mapper = mapper;
        this.publishMapper = publishMapper;
        this.publishService = publishService;
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
    @PostMapping("/publish")
    public ResponseEntity<Boolean> publish() {
        List<EtatBCMFluxEntrants> etatBCMPrevisionEcheances = etatBCFluxEntrantsService.findAll();
        boolean published = publishService.publishEtatBCMFluxEntrants(publishMapper.toDto(etatBCMPrevisionEcheances));
        return ResponseEntity.ok(published);
    }

    @PutMapping
    public ResponseEntity<Boolean> update(@RequestBody EtatBCMFluxEntrantsDto etatBCMFluxEntrantsDto) {
        return ResponseEntity.ok(etatBCFluxEntrantsService.update(this.mapper.toModel(etatBCMFluxEntrantsDto)));
    }

}
