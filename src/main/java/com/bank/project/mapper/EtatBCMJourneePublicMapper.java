package com.bank.project.mapper;

import com.bank.project.dto.BalanceGeneraleDto;
import com.bank.project.dto.JourneePublicDto;
import com.bank.project.model.EtatBCMBalanceGenerale;
import com.bank.project.model.EtatBCMJourneePublic;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EtatBCMJourneePublicMapper {
    JourneePublicDto toDto(EtatBCMJourneePublic etatBCMJourneePublic);
    List<JourneePublicDto> toDto(List<EtatBCMJourneePublic> etatBCMJourneePublicList);
    EtatBCMJourneePublic toModel(JourneePublicDto etatBCMJourneePublic);
}
