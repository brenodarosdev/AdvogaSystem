package com.AdvogaSystem.advogado.application.api;

import com.AdvogaSystem.advogado.application.service.AdvogadoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class AdvogadoController implements AdvogadoAPI {
    private final AdvogadoService advogadoService;

    @Override
    public AdvogadoCriadoResponse postCadastraNovoAdvogado(AdvogadoRequest advogadoNovoRequest) {
        log.info("[inicia] AdvogadoController - postCadastraNovoAdvogado");
        AdvogadoCriadoResponse advogadoCriadoResponse = advogadoService.cadastraNovoAdvogado(advogadoNovoRequest);
        log.info("[finaliza] AdvogadoController - postCadastraNovoAdvogado");
        return advogadoCriadoResponse;
    }
}
