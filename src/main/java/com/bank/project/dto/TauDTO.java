package com.bank.project.dto;

public class TauDTO {
    private Double tamon;
    private String tadiv;

    public TauDTO(Double tamon, String tadiv) {
        this.tamon = tamon;
        this.tadiv = tadiv;
    }

    // Getters and setters
    public Double getTamon() {
        return tamon;
    }

    public void setTamon(Double tamon) {
        this.tamon = tamon;
    }

    public String getTadiv() {
        return tadiv;
    }

    public void setTadiv(String tadiv) {
        this.tadiv = tadiv;
    }
}

