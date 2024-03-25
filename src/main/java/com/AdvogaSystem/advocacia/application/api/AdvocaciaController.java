package com.AdvogaSystem.advocacia.application.api;

import com.AdvogaSystem.advocacia.application.service.AdvocaciaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Log4j2
@RestController
@RequiredArgsConstructor
public class AdvocaciaController implements AdvocaciaAPI {
    private final AdvocaciaService advocaciaService;

    @Override
    public AdvocaciaCriadaResponse postCadastraNovaAdvocacia(AdvocaciaRequest advocaciaNovoRequest) {
        log.info("[inicia] AdvocaciaController - postCadastraNovaAdvocacia");
        AdvocaciaCriadaResponse advocaciaCriadaResponse = advocaciaService.cadastraNovaAdvocacia(advocaciaNovoRequest);
        log.info("[finaliza] AdvocaciaController - postCadastraNovaAdvocacia");
        return advocaciaCriadaResponse;
    }

    @Override
    public AdvocaciaDetalhadaResponse getBuscaAdvocaciaPorId(String token, UUID idAdvocacia) {
        log.info("[inicia] AdvocaciaController - getBuscaAdvocaciaPorId");
        log.info("[finaliza] AdvocaciaController - getBuscaAdvocaciaPorId");
        return null;
    }
}
