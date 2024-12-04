package com.bank.project.dao;

import com.bank.project.model.Caisse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaisseDao extends JpaRepository<Caisse, Integer> {
    Caisse findByCAUSCODE(int CAUSCODE);
}
