package com.bank.project.mapper;

import com.bank.project.dto.PrevisionEcheanceDto;
import com.bank.project.model.EtatBCMPrevisionEcheance;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrevisionEcheanceMapper {
    PrevisionEcheanceDto toDto(EtatBCMPrevisionEcheance etatBCMPrevisionEcheance);
    List<PrevisionEcheanceDto> toDto(List<EtatBCMPrevisionEcheance> etatBCMPrevisionEcheanceList);

    EtatBCMPrevisionEcheance toModel(PrevisionEcheanceDto previsionEcheanceDto);
}
