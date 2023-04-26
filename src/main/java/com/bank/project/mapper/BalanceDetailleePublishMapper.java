package com.bank.project.mapper;

import com.bank.project.dto.BalanceDetailleePublishDto;
import com.bank.project.dto.BalanceGeneralePublishDto;
import com.bank.project.model.EtatBCMBalanceDetaillee;
import com.bank.project.model.EtatBCMBalanceGenerale;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BalanceDetailleePublishMapper {
    BalanceDetailleePublishDto toDto(EtatBCMBalanceDetaillee etatBCMBalanceDetaillee);
    List<BalanceDetailleePublishDto> toDto(List<EtatBCMBalanceDetaillee> etatBCMBalanceDetailleeList);
}
