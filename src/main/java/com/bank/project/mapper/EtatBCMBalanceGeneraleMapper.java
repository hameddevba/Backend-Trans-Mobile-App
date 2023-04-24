package com.bank.project.mapper;

import com.bank.project.dto.BalanceGeneraleDto;
import com.bank.project.model.EtatBCMBalanceGenerale;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EtatBCMBalanceGeneraleMapper {
    BalanceGeneraleDto toDto(EtatBCMBalanceGenerale etatBCMBalanceGenerale);
    List<BalanceGeneraleDto> toDto(List<EtatBCMBalanceGenerale> etatBCMBalanceGeneraleList);
    EtatBCMBalanceGenerale toModel(BalanceGeneraleDto etatBCMBalanceGenerale);
}
