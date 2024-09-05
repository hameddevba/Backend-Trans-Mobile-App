package com.bank.project.dao;

import com.bank.project.dto.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenceDao extends JpaRepository<Agence,Long> {
}
