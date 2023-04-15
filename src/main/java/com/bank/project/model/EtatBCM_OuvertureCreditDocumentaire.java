package com.bank.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Date;


@Entity
public class EtatBCM_OuvertureCreditDocumentaire {

    @Id
    private Long id;

    @Column
    private String banque;

    @Column
    private String numCredoc;

    @Column
    private Date dateOuverture;

    @Column
    private String nomDonneurOrdre;

    @Column
    private BigDecimal montantOuverture;

    @Column
    private String devise;

    private String beneficiaire;

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

    public Date getDateOuverture() {
        return dateOuverture;
    }

    public void setDateOuverture(Date dateOuverture) {
        this.dateOuverture = dateOuverture;
    }

    public String getNomDonneurOrdre() {
        return nomDonneurOrdre;
    }

    public void setNomDonneurOrdre(String nomDonneurOrdre) {
        this.nomDonneurOrdre = nomDonneurOrdre;
    }

    public BigDecimal getMontantOuverture() {
        return montantOuverture;
    }

    public void setMontantOuverture(BigDecimal montantOuverture) {
        this.montantOuverture = montantOuverture;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public String getNomCorrespondant() {
        return nomCorrespondant;
    }

    public void setNomCorrespondant(String nomCorrespondant) {
        this.nomCorrespondant = nomCorrespondant;
    }

    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public BigDecimal getDeposite() {
        return deposite;
    }

    public void setDeposite(BigDecimal deposite) {
        this.deposite = deposite;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Column
    private String nomCorrespondant;
    @Column
    private String produit;
    @Column
    private BigDecimal deposite;
    @Column
    private String pays;

}
