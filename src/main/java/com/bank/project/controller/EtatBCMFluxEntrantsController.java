package com.bank.project.controller;

import com.bank.project.dto.EtatBCMFluxEntrantsDto;
import com.bank.project.dto.PagebaleDataDto;
import com.bank.project.mapper.EtatBCMFluxEntrantsMapper;
import com.bank.project.mapper.EtatBCMFluxEntrantsPublishMapper;
import com.bank.project.model.EtatBCMFluxEntrants;
import com.bank.project.service.EtatBCFluxEntrantsService;
import com.bank.project.service.PublishService;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/etatBCM_Flux_Entrants", produces = MediaType.APPLICATION_JSON_VALUE)
@PreAuthorize("hasRole('ADMIN') || hasRole('ETRANGER')")
public class EtatBCMFluxEntrantsController {
    private final EtatBCFluxEntrantsService service;

    private final EtatBCMFluxEntrantsMapper mapper;
    private final EtatBCMFluxEntrantsPublishMapper publishMapper;
    private final PublishService publishService;

    public EtatBCMFluxEntrantsController(EtatBCFluxEntrantsService service, EtatBCMFluxEntrantsMapper mapper,
                                         EtatBCMFluxEntrantsPublishMapper publishMapper, PublishService publishService) {
        this.service = service;
        this.mapper = mapper;
        this.publishMapper = publishMapper;
        this.publishService = publishService;
    }

    @GetMapping
    public ResponseEntity<PagebaleDataDto<EtatBCMFluxEntrantsDto>> getAllEtatBCMFluxEntrants(@Param("page") int page, @Param("size") int size) {
        Page<EtatBCMFluxEntrants> etatBCMFluxEntrants = service.findEchantillon(page,size);
        PagebaleDataDto<EtatBCMFluxEntrantsDto> pages = new PagebaleDataDto<>();
        pages.setTotal(etatBCMFluxEntrants.getTotalPages());
        pages.setData(mapper.toDto(etatBCMFluxEntrants.getContent()));
        return ResponseEntity.ok(pages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtatBCMFluxEntrantsDto> getEtatBCMFluxSortant(
            @PathVariable final Long id) {
        EtatBCMFluxEntrants etatBCMFluxEntrants = service.findById(id);
        return ResponseEntity.ok(mapper.toDto(etatBCMFluxEntrants));
    }
    @PostMapping("/publish")
    public ResponseEntity<Boolean> publish() {
        List<EtatBCMFluxEntrants> etatBCMPrevisionEcheances = service.findAll();
        boolean published = publishService.publishEtatBCMFluxEntrants(publishMapper.toDto(etatBCMPrevisionEcheances));
        return ResponseEntity.ok(published);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN') || hasRole('MODIFICATION')")
    public ResponseEntity<Boolean> update(@RequestBody EtatBCMFluxEntrantsDto etatBCMFluxEntrantsDto) {
        return ResponseEntity.ok(service.update(this.mapper.toModel(etatBCMFluxEntrantsDto)));
    }

}
