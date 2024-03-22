package com.AdvogaSystem.advocacia.application.service;

import com.AdvogaSystem.advocacia.application.api.AdvocaciaCriadaResponse;
import com.AdvogaSystem.advocacia.application.api.AdvocaciaRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class AdvocaciaApplicationService implements AdvocaciaService {
    @Override
    public AdvocaciaCriadaResponse cadastraNovaAdvocacia(AdvocaciaRequest advocaciaNovoRequest) {
        log.info("[inicia] AdvocaciaApplicationService - cadastraNovaAdvocacia");
        log.info("[finaliza] AdvocaciaApplicationService - cadastraNovaAdvocacia");
        return null;
    }
}
