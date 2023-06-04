package com.bank.project.mapper;

import com.bank.project.dto.RoleDto;
import com.bank.project.model.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDto toDto(Role role);
    List<RoleDto> toDto(List<Role> role);
    Role toModel(RoleDto roleDto);


}
