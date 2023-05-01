package com.bank.project.mapper;

import com.bank.project.dto.FluxSortantsPublishDto;
import com.bank.project.model.EtatBCMFluxSortants;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FluxSortantsPublishMapper {
    FluxSortantsPublishDto toDto(EtatBCMFluxSortants etatBCMFluxSortants);
    List<FluxSortantsPublishDto> toDto(List<EtatBCMFluxSortants> etatBCMFluxSortantsList);
}
