package com.bank.project.dao;


import com.bank.project.model.Trans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransDao extends JpaRepository<Trans, Long> {

}
