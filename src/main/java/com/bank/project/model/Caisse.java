package com.bank.project.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;


@Entity
@Table(name = "caisse")
public class Caisse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CACODE;

    private int cancp;
    private int CAAGCODE;

    @Column(unique = true)
    private int CAUSCODE;

    private String CADEV;
    private String cadeven;
    private BigDecimal CASDE;
    private String CAETA;
    private String CAETAAD;
    private Integer CA_MODIF_TAU;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp CADATE;

    // Getters and Setters
    public Integer getCA_MODIF_TAU() {
        return CA_MODIF_TAU;
    }

    public void setCA_MODIF_TAU(Integer CA_MODIF_TAU) {
        this.CA_MODIF_TAU = CA_MODIF_TAU;
    }

    public int getCAUSCODE() {
        return CAUSCODE;
    }

    public void setCAUSCODE(int CAUSCODE) {
        this.CAUSCODE = CAUSCODE;
    }
}
