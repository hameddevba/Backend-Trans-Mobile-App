package com.bank.project.mapper;

import com.bank.project.dto.EtatBCM_PrevisionEcheanceDto;
import com.bank.project.model.EtatBCM_PrevisionEcheance;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EtatBCM_PrevisionEcheanceMapper {
    EtatBCM_PrevisionEcheanceDto toDto(EtatBCM_PrevisionEcheance etatBCM_PrevisionEcheance);
    List<EtatBCM_PrevisionEcheanceDto> toDto(List<EtatBCM_PrevisionEcheance> EtatBCM_PrevisionEcheanceList);
}
