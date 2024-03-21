package com.AdvogaSystem.advogado.application.api;

import com.AdvogaSystem.advogado.domain.Advogado;
import lombok.Value;

import java.util.UUID;

@Value
public class AdvogadoCriadoResponse {
    private UUID idAdvogado;

    public AdvogadoCriadoResponse(Advogado advogado) {
        this.idAdvogado = advogado.getIdAdvogado();
    }
}
