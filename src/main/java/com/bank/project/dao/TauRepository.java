package com.bank.project.dao;

import com.bank.project.dto.TauDTO;
import com.bank.project.model.Tau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TauRepository extends JpaRepository<Tau, Long> {

    @Query("SELECT new com.bank.project.dto.TauDTO(t.tamon, t.tadiv) FROM Tau t " +
            "WHERE :montant <= t.tab2 " +
            "AND :montant > t.tab1 " +
            "AND t.taav = 'v' " +
            "AND t.tacat LIKE CONCAT(:prefix, '%') " +
            "AND t.tadev = 'MRO' " +
            "AND t.tadeven = 'CFA'")
    List<TauDTO> findByCriteria(@Param("montant") Double montant, @Param("prefix") String prefix);
}

