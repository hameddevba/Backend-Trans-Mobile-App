package com.bank.project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tarif_wari")
public class TarifWari {

    @Id
    private Long id;

    @Column(name = "twtarif")
    private Double twtarif;

    @Column(name = "twtyp")
    private String twtyp;

    @Column(name = "twcat")
    private String twcat;

    @Column(name = "twbsup")
    private Double twbsup;

    @Column(name = "twbinf")
    private Double twbinf;

    public Double getTwtarif() {
        return twtarif;
    }

    public void setTwtarif(Double twtarif) {
        this.twtarif = twtarif;
    }

    public String getTwtyp() {
        return twtyp;
    }

    public void setTwtyp(String twtyp) {
        this.twtyp = twtyp;
    }

    public String getTwcat() {
        return twcat;
    }

    public void setTwcat(String twcat) {
        this.twcat = twcat;
    }

    public Double getTwbsup() {
        return twbsup;
    }

    public void setTwbsup(Double twbsup) {
        this.twbsup = twbsup;
    }

    public Double getTwbinf() {
        return twbinf;
    }

    public void setTwbinf(Double twbinf) {
        this.twbinf = twbinf;
    }

}
