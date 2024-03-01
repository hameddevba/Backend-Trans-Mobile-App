package com.bank.project.mapper;

import com.bank.project.dto.TransDto;
import com.bank.project.model.Trans;
import org.mapstruct.Mapper;

import java.util.List;

//@Mapper(componentModel = "spring",uses = {EnvoyeurMapper.class, BenefMapper.class})
@Mapper(componentModel = "spring")
public interface TransMapper {
    TransDto toDto(Trans trans);
    List<TransDto> toDto(List<Trans> trans);
    Trans toModel(TransDto transDto);


}
