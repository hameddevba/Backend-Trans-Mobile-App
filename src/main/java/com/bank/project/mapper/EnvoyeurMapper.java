package com.bank.project.mapper;

import com.bank.project.dto.EnvoyeurDto;
import com.bank.project.dto.RoleDto;
import com.bank.project.model.Envoyeur;
import com.bank.project.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EnvoyeurMapper {
    EnvoyeurDto toDto(Envoyeur envoyeur);
    List<EnvoyeurDto> toDto(List<Envoyeur> envoyeur);
    @Mapping(target="entel", source="envoyeurDto.entel")
    Envoyeur toModel(EnvoyeurDto envoyeurDto);


}
