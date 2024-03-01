package com.bank.project.mapper;

import com.bank.project.dto.EnvoyeurDto;
import com.bank.project.dto.RoleDto;
import com.bank.project.model.Envoyeur;
import com.bank.project.model.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EnvoyeurMapper {
    EnvoyeurDto toDto(Envoyeur envoyeur);
    List<EnvoyeurDto> toDto(List<Envoyeur> envoyeur);
    Envoyeur toModel(EnvoyeurDto envoyeurDto);


}
