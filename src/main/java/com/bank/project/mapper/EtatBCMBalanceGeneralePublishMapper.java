package com.bank.project.mapper;

import com.bank.project.dto.BalanceGeneralePublishDto;
import com.bank.project.model.EtatBCMBalanceGenerale;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EtatBCMBalanceGeneralePublishMapper {
    BalanceGeneralePublishDto toDto(EtatBCMBalanceGenerale etatBCMBalanceGenerale);
    List<BalanceGeneralePublishDto> toDto(List<EtatBCMBalanceGenerale> etatBCMBalanceGeneraleList);
}
