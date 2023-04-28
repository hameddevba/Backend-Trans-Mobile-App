package com.bank.project.mapper;

import com.bank.project.dto.FluxSortantsDto;
import com.bank.project.model.EtatBCMFluxSortants;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FluxSortantsMapper {
    FluxSortantsDto toDto(EtatBCMFluxSortants etatBCMFluxSortants);
    List<FluxSortantsDto> toDto(List<EtatBCMFluxSortants> etatBCMFluxSortantsList);
    EtatBCMFluxSortants toModel(FluxSortantsDto fluxSortantsDto);
}
