package com.bank.project.dao;

import com.bank.project.model.EtatBCMBalanceDetaillee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EtatBCMBalanceDetailleeDao extends JpaRepository<EtatBCMBalanceDetaillee, Long> {
    @Query(value = "SELECT * FROM etatbcmbalance_detaillee where rownum<30",nativeQuery = true)
    List<EtatBCMBalanceDetaillee> findEchantillon();
}
