package com.bank.project;

import com.fasterxml.jackson.annotation.JsonFormat;


import java.math.BigDecimal;
import java.util.Date;

public class EtatBCMBalanceGeneraleDto {
    private Long id;

    @JsonFormat(pattern = "ddmmyyyy")
    private Date dateClotureBalance;

    private String compte;


    private String intituleCompte;

    private String devise;

    private Integer resident;

    private BigDecimal soldeDebiteur;

    private BigDecimal soldeCrediteur;
}
