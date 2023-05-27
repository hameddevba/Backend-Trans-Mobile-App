package com.bank.project.controller;

import com.bank.project.dto.BalanceGeneraleDto;
import com.bank.project.dto.PagebaleDataDto;
import com.bank.project.mapper.EtatBCMBalanceGeneraleMapper;
import com.bank.project.mapper.EtatBCMBalanceGeneralePublishMapper;
import com.bank.project.model.EtatBCMBalanceGenerale;
import com.bank.project.service.EtatBCMBalanceGeneraleService;
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
@RequestMapping(value = "/api/etatBCMBalanceGenerales", produces = MediaType.APPLICATION_JSON_VALUE)
@PreAuthorize("hasRole('ADMIN') || hasRole('COMPTABLE')")
public class EtatBCMBalanceGeneraleController {
    private final EtatBCMBalanceGeneraleService service;
    private final PublishService publishService;

    private final EtatBCMBalanceGeneraleMapper mapper;
    private final EtatBCMBalanceGeneralePublishMapper publishMapper;

    public EtatBCMBalanceGeneraleController(
            final EtatBCMBalanceGeneraleService service, final PublishService publishService,
            final EtatBCMBalanceGeneraleMapper etatBCMBalanceGeneraleMapper, final EtatBCMBalanceGeneralePublishMapper etatBCMBalanceGeneralePublishMapper) {
        this.service = service;
        this.publishService = publishService;
        this.mapper = etatBCMBalanceGeneraleMapper;
        this.publishMapper = etatBCMBalanceGeneralePublishMapper;
    }

    @GetMapping
    public ResponseEntity<PagebaleDataDto<BalanceGeneraleDto>> getAllEtatBCMBalanceGenerales(@Param("page") int page, @Param("size") int size) {
        Page<EtatBCMBalanceGenerale> etatBCMBalanceGenerales = service.findEchantillon(page,size);
        PagebaleDataDto<BalanceGeneraleDto> pages = new PagebaleDataDto<>();
        pages.setTotal(etatBCMBalanceGenerales.getTotalPages());
        pages.setData(mapper.toDto(etatBCMBalanceGenerales.getContent()));
        return ResponseEntity.ok(pages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BalanceGeneraleDto> getEtatBCMBalanceGenerale(
            @PathVariable final Long id) {
        EtatBCMBalanceGenerale etatBCMBalanceGenerale = service.findById(id);
        return ResponseEntity.ok(mapper.toDto(etatBCMBalanceGenerale));
    }

    @PostMapping("/publish")
    public ResponseEntity<Boolean> publish() {
        List<EtatBCMBalanceGenerale> etatBCMBalanceGenerales = service.findAll();
        boolean published = publishService.publishEtatGenerale(publishMapper.toDto(etatBCMBalanceGenerales));
        return ResponseEntity.ok(published);
    }
    @PostMapping("/publishmensuel")
    public ResponseEntity<Boolean> publishmensuel() {
        List<EtatBCMBalanceGenerale> etatBCMBalanceGenerales = service.findAll();
        boolean published = publishService.publishEtatGeneraleMensuel(publishMapper.toDto(etatBCMBalanceGenerales));
        return ResponseEntity.ok(published);
    }
    @PostMapping("/publishannuel")
    public ResponseEntity<Boolean> publishannuel() {
        List<EtatBCMBalanceGenerale> etatBCMBalanceGenerales = service.findAll();
        boolean published = publishService.publishEtatGeneraleAnnuel(publishMapper.toDto(etatBCMBalanceGenerales));
        return ResponseEntity.ok(published);
    }
    @GetMapping("/export")
    public ResponseEntity<byte[]> export(String param) throws IOException {
        String filename = new SimpleDateFormat("'balanceGenerale_'yyyyMMddHHmm'.csv'").format(new Date());
        StringWriter sw = service.exportData();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE); // (3) Content-Type: application/octet-stream
        httpHeaders.set(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment().filename(filename).build().toString()); // (4) Content-Disposition: attachment; filename="demo-file.txt"
        return ResponseEntity.ok().headers(httpHeaders).body(sw.toString().getBytes());
    }
    @PutMapping
    @PreAuthorize("hasRole('ADMIN') || hasRole('MODIFICATION')")
    public ResponseEntity<Boolean> update(@RequestBody BalanceGeneraleDto etatBCMBalanceGenerale) {
        return ResponseEntity.ok(service.update(this.mapper.toModel(etatBCMBalanceGenerale)));
    }
}
