package com.bank.project.mapper;

import com.bank.project.dto.EtatBCMFluxEntrantsDto;
import com.bank.project.model.EtatBCMFluxEntrants;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EtatBCMFluxEntrantsMapper {
    EtatBCMFluxEntrantsDto toDto(EtatBCMFluxEntrants etatBCMFluxEntrants);
    List<EtatBCMFluxEntrantsDto> toDto(List<EtatBCMFluxEntrants> etatBCMFluxEntrants);
}
