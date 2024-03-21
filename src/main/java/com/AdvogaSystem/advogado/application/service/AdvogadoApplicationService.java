package com.AdvogaSystem.advogado.application.service;

import com.AdvogaSystem.advogado.application.api.AdvogadoCriadoResponse;
import com.AdvogaSystem.advogado.application.api.AdvogadoRequest;
import com.AdvogaSystem.advogado.application.repository.AdvogadoRepository;
import com.AdvogaSystem.advogado.domain.Advogado;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
@Log4j2
@Service
@RequiredArgsConstructor
public class AdvogadoApplicationService implements AdvogadoService {
    private final AdvogadoRepository advogadoRepository;

    @Override
    public AdvogadoCriadoResponse cadastraNovoAdvogado(AdvogadoRequest advogadoNovoRequest) {
        log.info("[inicia] AdvogadoApplicationService - cadastraNovoAdvogado");
        Advogado advogado = advogadoRepository.salva(new Advogado(advogadoNovoRequest));
        log.info("[finaliza] AdvogadoApplicationService - cadastraNovoAdvogado");
        return null;
    }
}
