package com.AdvogaSystem.advocacia.application.api;

import com.AdvogaSystem.advocacia.domain.Advocacia;
import lombok.Value;

import java.util.UUID;

@Value
public class AdvocaciaCriadaResponse {
    private UUID idAdvocacia;

    public AdvocaciaCriadaResponse(Advocacia advocacia) {
        this.idAdvocacia = advocacia.getIdAdvocacia();
    }
}
