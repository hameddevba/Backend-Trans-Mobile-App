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
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value = "/api/etatBCMBalanceDetaillees", produces = MediaType.APPLICATION_JSON_VALUE)
@PreAuthorize("hasRole('ADMIN') || hasRole('ROLE_BALANCEDETAILL')")
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
        Page<EtatBCMBalanceDetaillee> etatBCMBalanceDetaillees = etatBCMBalanceDetailleeService.findEchantillon(page, size);
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
    @PreAuthorize("hasRole('ADMIN') || hasRole('MODIFICATION')")
    public ResponseEntity<Boolean> update(@RequestBody BalanceDetailleeDto etatBCMBalanceDetaillee) {
        return ResponseEntity.ok(etatBCMBalanceDetailleeService.update(this.mapper.toModel(etatBCMBalanceDetaillee)));
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> export(String param) throws IOException {
        String filename = new SimpleDateFormat("'balanceDetaillee_'yyyyMMddHHmm'.csv'").format(new Date());
        StringWriter sw = etatBCMBalanceDetailleeService.exportData();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE); // (3) Content-Type: application/octet-stream
        httpHeaders.set(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment().filename(filename).build().toString()); // (4) Content-Disposition: attachment; filename="demo-file.txt"
        return ResponseEntity.ok().headers(httpHeaders).body(sw.toString().getBytes());
    }



}
