package com.bank.project.controller;

import com.bank.project.dto.TransDto;
import com.bank.project.mapper.TransMapper;
import com.bank.project.model.Trans;
import com.bank.project.service.TransService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static org.springframework.http.MediaType.IMAGE_JPEG;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@RestController
@RequestMapping(value ="/api/trans")
//@PreAuthorize("hasRole('ADMIN')")
public class TransController {


    @Autowired
    TransService transService;
    @Autowired
    TransMapper mapper;

    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping
    public List<TransDto> findAll(){
        List<Trans> transes = transService.find();
          return mapper.toDto(transes);
    }

    @GetMapping("filtre/{number}/{agence}")
    public List<TransDto> findFiltreTrans(@PathVariable String number, @PathVariable int agence){
       return transService.findFiltreTrans(number,agence);
    }
    @GetMapping("/env/{number}")
    public List<TransDto> findTransAll(@PathVariable String number){
        return transService.findTransByEnv(number);
    }

    @GetMapping("/{id}")
    public TransDto findById(@PathVariable Long id){
        Trans trans = transService.findById(id);
        return mapper.toDto(trans);
    }
//    @PostMapping("/changetrans")
//    public TransDto save(@RequestBody TransDto transDto) {
//        Trans trans = transService.save(this.mapper.toModel(transDto));
//        return mapper.toDto(trans);
//    }

    @PatchMapping("/image-upload/{code}")
    public ResponseEntity<String> save(@PathVariable Long code, @RequestParam("file") MultipartFile file) throws IOException {
        transService.uploadFile(code, file);
        return ResponseEntity.ok("fichier enregistrer");
    }


    @GetMapping("/image/{code}")
    public ResponseEntity<?> getImage(@PathVariable Long code) throws IOException {
        byte[] image = transService.findById(code).getTRAVIS();
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf(IMAGE_PNG_VALUE))
                .contentType(MediaType.valueOf(String.valueOf(IMAGE_JPEG)))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + code + "\"")
                .body(image);
    }
    @PostMapping("/changetrans")
    public TransDto save(@RequestParam("data") String stransDto) throws JsonProcessingException {
        TransDto transDto = objectMapper.readValue(stransDto, TransDto.class);
        return transService.addTrans(transDto);
    }
    
}
