package com.bank.project.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Date;


public class EtatBCMPrevisionEcheanceDto {

    @Id
    private Long id;

    @Column
    private String banque;

    @Column
    private String numCredoc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Column
    private Date dateEcheance;

    @Column
    private BigDecimal montantEcheance;

    @Column
    private String devise;

}
