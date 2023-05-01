package com.bank.project.dto;

import jakarta.persistence.Id;


public class OuvertureCreditDocumentaireDto extends OuvertureCreditDocumentairePublishDto{

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
