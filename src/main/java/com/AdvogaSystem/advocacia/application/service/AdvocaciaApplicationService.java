package com.AdvogaSystem.advocacia.application.service;

import com.AdvogaSystem.advocacia.application.api.AdvocaciaCriadaResponse;
import com.AdvogaSystem.advocacia.application.api.AdvocaciaRequest;
import com.AdvogaSystem.advocacia.application.repository.AdvocaciaRepository;
import com.AdvogaSystem.advocacia.domain.Advocacia;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class AdvocaciaApplicationService implements AdvocaciaService {
    private final AdvocaciaRepository advocaciaRepository;

    @Override
    public AdvocaciaCriadaResponse cadastraNovaAdvocacia(AdvocaciaRequest advocaciaNovoRequest) {
        log.info("[inicia] AdvocaciaApplicationService - cadastraNovaAdvocacia");
        Advocacia advocacia = advocaciaRepository.salva(new Advocacia(advocaciaNovoRequest));
        log.info("[finaliza] AdvocaciaApplicationService - cadastraNovaAdvocacia");
        return null;
    }
}
