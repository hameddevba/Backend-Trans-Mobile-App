package com.bank.project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.util.Date;


public class FluxSortantsDto extends FluxSortantsPublishDto{
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;

}
