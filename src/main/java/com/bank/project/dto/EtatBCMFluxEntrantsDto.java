package com.bank.project.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Date;


public class EtatBCMFluxEntrantsDto extends EtatBCMFluxEntrantsPublishDto{

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
