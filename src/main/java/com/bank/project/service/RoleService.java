package com.bank.project.service;

import com.bank.project.dao.RoleDao;
import com.bank.project.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;


    public List<Role> findAll() {
        return roleDao.findAll(Sort.by("id"));
    }

}
