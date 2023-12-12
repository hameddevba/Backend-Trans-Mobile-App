package com.bank.project.model;

import com.bank.project.model.enums.ResidentEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


@Entity
public class EtatBCMJourneePublic {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String banque;

    @Column
    private Date datePublic;


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

    public Date getDatePublic() {
        return datePublic;
    }

    public void setDatePublic(Date datePublic) {
        this.datePublic = datePublic;
    }



}

