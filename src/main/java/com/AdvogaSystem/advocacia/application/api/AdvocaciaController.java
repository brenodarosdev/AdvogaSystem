package com.AdvogaSystem.advocacia.application.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class AdvocaciaController implements AdvocaciaAPI {
    @Override
    public AdvocaciaCriadaResponse postCadastraNovaAdvocacia(AdvocaciaRequest advocaciaNovoRequest) {
        log.info("[inicia] AdvocaciaController - postCadastraNovaAdvocacia");
        log.info("[finaliza] AdvocaciaController - postCadastraNovaAdvocacia");
        return null;
    }
}
