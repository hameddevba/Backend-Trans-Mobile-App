package com.bank.project.dao;


import com.bank.project.dto.TransDto;
import com.bank.project.model.Trans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransDao extends JpaRepository<Trans, Long> {

    List<Trans> findByEnvoyeur_EntelAndEnvoyeur_Enagcode(String number, int agence);
    List<Trans> findByEnvoyeur_EntelOrderByTrcodeDesc(String number);
}
