package com.bank.project.mapper;

import com.bank.project.dto.Agence;
import com.bank.project.dto.AgenceDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgenceMapper {
    Agence toAgenceModel(AgenceDto agenceDto);
    List<AgenceDto> toAgenceDto(List<Agence> agences);
}
