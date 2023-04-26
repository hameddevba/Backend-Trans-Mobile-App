package com.bank.project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;


public class PrevisionEcheancePublishDto {

    private String banque;

    private String numCredoc;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date dateEcheance;

    private BigDecimal montantEcheance;

    private String devise;

    public String getBanque() {
        return banque;
    }

    public void setBanque(String banque) {
        this.banque = banque;
    }

    public String getNumCredoc() {
        return numCredoc;
    }

    public void setNumCredoc(String numCredoc) {
        this.numCredoc = numCredoc;
    }

    public Date getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(Date dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public BigDecimal getMontantEcheance() {
        return montantEcheance;
    }

    public void setMontantEcheance(BigDecimal montantEcheance) {
        this.montantEcheance = montantEcheance;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }


}
