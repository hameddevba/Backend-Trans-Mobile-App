package com.bank.project.controller;

import com.bank.project.dto.BalanceDetailleeDto;
import com.bank.project.dto.PagebaleDataDto;
import com.bank.project.mapper.BalanceDetailleeMapper;
import com.bank.project.mapper.BalanceDetailleePublishMapper;
import com.bank.project.model.EtatBCMBalanceDetaillee;
import com.bank.project.service.EtatBCMBalanceDetailleeService;
import com.bank.project.service.PublishService;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
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
    public ResponseEntity<PagebaleDataDto<BalanceDetailleeDto>> getAllEtatBCMBalanceDetaillees(@Param("page") int page, @Param("size") int size) {
        Page<EtatBCMBalanceDetaillee> etatBCMBalanceDetaillees = etatBCMBalanceDetailleeService.findEchantillon(page,size);
        PagebaleDataDto<BalanceDetailleeDto> pages = new PagebaleDataDto<>();
        pages.setTotal(etatBCMBalanceDetaillees.getTotalPages());
        pages.setData(mapper.toDto(etatBCMBalanceDetaillees.getContent()));
        return ResponseEntity.ok(pages);
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

    @PostMapping("/publishmensuel")
    public ResponseEntity<Boolean> publishmensuel() {
        List<EtatBCMBalanceDetaillee> etatBCMBalanceDetaillees = etatBCMBalanceDetailleeService.findAll();
        boolean published = publishService.publishEtatBalanceDetailleeMensuel(publishMapper.toDto(etatBCMBalanceDetaillees));
        return ResponseEntity.ok(published);
    }

    @PostMapping("/publishannuel")
    public ResponseEntity<Boolean> publishannuel() {
        List<EtatBCMBalanceDetaillee> etatBCMBalanceDetaillees = etatBCMBalanceDetailleeService.findAll();
        boolean published = publishService.publishEtatBalanceDetailleeAnnuel(publishMapper.toDto(etatBCMBalanceDetaillees));
        return ResponseEntity.ok(published);
    }

    @PutMapping
    public ResponseEntity<Boolean> update(@RequestBody BalanceDetailleeDto etatBCMBalanceDetaillee) {
        return ResponseEntity.ok(etatBCMBalanceDetailleeService.update(this.mapper.toModel(etatBCMBalanceDetaillee)));
    }

}
