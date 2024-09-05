package com.bank.project.model;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.sql.Time;
import java.util.Objects;
import java.util.List;
@Entity
public class Benef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bNCODE;
    private Integer bNAGCODE;
    private String bNNOM;
    private String bNPRE;
    private String bNPI;
    private String bNTYPP;
    private String bntel;
    private String bNADD;
    private Timestamp bNDATE;
    private Integer bNUSCODE;


    public Integer getBNCODE(){
        return bNCODE;
    }

    public void setBNCODE(Integer bNCODE){
        this.bNCODE=bNCODE;
    }

    public Integer getBNAGCODE(){
        return bNAGCODE;
    }

    public void setBNAGCODE(Integer bNAGCODE){
        this.bNAGCODE=bNAGCODE;
    }

    public String getBNNOM(){
        return bNNOM;
    }

    public void setBNNOM(String bNNOM){
        this.bNNOM=bNNOM;
    }

    public String getBNPRE(){
        return bNPRE;
    }

    public void setBNPRE(String bNPRE){
        this.bNPRE=bNPRE;
    }

    public String getBNPI(){
        return bNPI;
    }

    public void setBNPI(String bNPI){
        this.bNPI=bNPI;
    }

    public String getBNTYPP(){
        return bNTYPP;
    }

    public void setBNTYPP(String bNTYPP){
        this.bNTYPP=bNTYPP;
    }

    public String getBNTEL(){
        return bntel;
    }

    public void setBNTEL(String bNTEL){
        this.bntel=bNTEL;
    }

    public String getBNADD(){
        return bNADD;
    }

    public void setBNADD(String bNADD){
        this.bNADD=bNADD;
    }

    public Timestamp getBNDATE(){
        return bNDATE;
    }

    public void setBNDATE(Timestamp bNDATE){
        this.bNDATE=bNDATE;
    }

    public Integer getBNUSCODE(){
        return bNUSCODE;
    }

    public void setBNUSCODE(Integer bNUSCODE){
        this.bNUSCODE=bNUSCODE;
    }


}
