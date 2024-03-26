package com.AdvogaSystem.advocacia.application.api;

import com.AdvogaSystem.advocacia.domain.Advocacia;
import lombok.Value;

import java.util.UUID;

@Value
public class AdvocaciaDetalhadaResponse {
    private UUID idAdvocacia;
    private String email;
    private String nomeDaAdvocacia;

    public AdvocaciaDetalhadaResponse(Advocacia advocacia) {
        this.idAdvocacia = advocacia.getIdAdvocacia();
        this.email = advocacia.getEmail();
        this.nomeDaAdvocacia = advocacia.getNomeDaAdvocacia();
    }
}
