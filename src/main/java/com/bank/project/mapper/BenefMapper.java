package com.bank.project.mapper;

import com.bank.project.dto.BenefDto;
import com.bank.project.dto.EnvoyeurDto;
import com.bank.project.model.Benef;
import com.bank.project.model.Envoyeur;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BenefMapper {
    BenefDto toDto(Benef benef);
    List<BenefDto> toDto(List<Benef> benef);
    Benef toModel(BenefDto benefDto);


}
