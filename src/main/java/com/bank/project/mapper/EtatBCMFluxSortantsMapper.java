package com.bank.project.mapper;

import com.bank.project.dto.EtatBCMFluxSortantsDto;
import com.bank.project.model.EtatBCMFluxSortants;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EtatBCMFluxSortantsMapper {
    EtatBCMFluxSortantsDto toDto(EtatBCMFluxSortants etatBCMFluxSortants);
    List<EtatBCMFluxSortantsDto> toDto(List<EtatBCMFluxSortants> etatBCMFluxSortantsList);
}
