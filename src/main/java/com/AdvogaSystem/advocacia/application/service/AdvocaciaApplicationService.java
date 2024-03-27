package com.AdvogaSystem.advocacia.application.service;

import com.AdvogaSystem.advocacia.application.api.AdvocaciaCriadaResponse;
import com.AdvogaSystem.advocacia.application.api.AdvocaciaDetalhadaResponse;
import com.AdvogaSystem.advocacia.application.api.AdvocaciaRequest;
import com.AdvogaSystem.advocacia.application.repository.AdvocaciaRepository;
import com.AdvogaSystem.advocacia.domain.Advocacia;
import com.AdvogaSystem.credencial.application.service.CredencialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class AdvocaciaApplicationService implements AdvocaciaService {
    private final AdvocaciaRepository advocaciaRepository;
    private final CredencialService credencialService;

    @Override
    public AdvocaciaCriadaResponse cadastraNovaAdvocacia(AdvocaciaRequest advocaciaNovoRequest) {
        log.info("[inicia] AdvocaciaApplicationService - cadastraNovaAdvocacia");
        credencialService.criaNovaCredencial(advocaciaNovoRequest);
        Advocacia advocacia = advocaciaRepository.salva(new Advocacia(advocaciaNovoRequest));
        log.info("[finaliza] AdvocaciaApplicationService - cadastraNovaAdvocacia");
        return new AdvocaciaCriadaResponse(advocacia);
    }

    @Override
    public AdvocaciaDetalhadaResponse buscaAdvocaciaPorId(String emailAdvocacia, UUID idAdvocacia) {
        log.info("[inicia] AdvocaciaApplicationService - buscaAdvocaciaPorId");
        Advocacia advocaciaPorEmail = advocaciaRepository.advocaciaPorEmail(emailAdvocacia);
        advocaciaRepository.advocaciaPorId(idAdvocacia);
        advocaciaPorEmail.validaAdvocacia(idAdvocacia);
        log.info("Advocacia validada - O token pertence à Advocacia");
        log.info("[finaliza] AdvocaciaApplicationService - buscaAdvocaciaPorId");
        return new AdvocaciaDetalhadaResponse(advocaciaPorEmail);
    }

    @Override
    public void alteraAdvocacia(String emailAdvocacia, UUID idAdvocacia, AdvocaciaRequest alteraAdvocaciaRequest) {
        log.info("[inicia] AdvocaciaApplicationService - alteraAdvocacia");
        Advocacia advocaciaPorEmail = advocaciaRepository.advocaciaPorEmail(emailAdvocacia);
        advocaciaRepository.advocaciaPorId(idAdvocacia);
        advocaciaPorEmail.validaAdvocacia(idAdvocacia);
        log.info("Advocacia validada - O token pertence à Advocacia");
        advocaciaPorEmail.alteraAdvocacia(alteraAdvocaciaRequest);
        credencialService.criaNovaCredencial(alteraAdvocaciaRequest);
        advocaciaRepository.salva(advocaciaPorEmail);
        log.info("[finaliza] AdvocaciaApplicationService - alteraAdvocacia");
    }

    @Override
    public void deletaAdvocacia(String emailAdvocacia, UUID idAdvocacia) {
        log.info("[inica] AdvocaciaApplicationService - deletaAdvocacia");
        log.info("[finaliza] AdvocaciaApplicationService - deletaAdvocacia");

    }
}
