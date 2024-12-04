package com.bank.project.dao;

import com.bank.project.model.TarifWari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TarifWariRepository extends JpaRepository<TarifWari, Long> {

    @Query("SELECT t.twtarif, t.twtyp FROM TarifWari t " + "WHERE t.twcat LIKE CONCAT(:prefix, '%') " + "AND :montant <= t.twbsup " + "AND :montant > t.twbinf")
    List<Object[]> findTarifWari(@Param("prefix") String prefix, @Param("montant") Double montant);
}
