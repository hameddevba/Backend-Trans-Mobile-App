package com.bank.project.mapper;

import com.bank.project.dto.EtatBCMBalanceGeneraleDto;
import com.bank.project.model.EtatBCMBalanceGenerale;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EtatBCMBalanceGeneraleMapper {
    EtatBCMBalanceGeneraleDto toDto(EtatBCMBalanceGenerale etatBCMBalanceGenerale);
    List<EtatBCMBalanceGeneraleDto> toDto(List<EtatBCMBalanceGenerale> etatBCMBalanceGeneraleList);
    EtatBCMBalanceGenerale toModel(EtatBCMBalanceGeneraleDto etatBCMBalanceGenerale);


}
