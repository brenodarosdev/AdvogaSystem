package com.AdvogaSystem.advogado.application.service;

import com.AdvogaSystem.advogado.application.api.AdvogadoCriadoResponse;
import com.AdvogaSystem.advogado.application.api.AdvogadoRequest;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
@Log4j2
@Service
public class AdvogadoApplicationService implements AdvogadoService {
    @Override
    public AdvogadoCriadoResponse cadastraNovoAdvogado(AdvogadoRequest advogadoNovoRequest) {
        log.info("[inicia] AdvogadoApplicationService - cadastraNovoAdvogado");
        log.info("[finaliza] AdvogadoApplicationService - cadastraNovoAdvogado");
        return null;
    }
}
