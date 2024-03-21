package com.AdvogaSystem.advogado.application.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class AdvogadoController implements AdvogadoAPI {
    @Override
    public AdvogadoCriadoResponse postCadastraNovoAdvogado(AdvogadoRequest advogadoNovoRequest) {
        log.info("[inicia] AdvogadoController - postCadastraNovoAdvogado");
        log.info("[finaliza] AdvogadoController - postCadastraNovoAdvogado");
        return null;
    }
}
