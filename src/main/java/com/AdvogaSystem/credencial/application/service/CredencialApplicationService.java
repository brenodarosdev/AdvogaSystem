package com.AdvogaSystem.credencial.application.service;

import com.AdvogaSystem.credencial.application.repository.CredencialRepository;
import com.AdvogaSystem.credencial.domain.Credencial;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Log4j2
public class CredencialApplicationService implements CredencialService {
    private final CredencialRepository credencialRepository;
    @Override
    public Credencial buscaCredencialPorEmail(String email) {
        log.info("[inicia] CredencialApplicationService - buscaCredencialPorEmail");
        Credencial credencial = credencialRepository.buscaCredencialPorEmail(email);
        log.info("[finaliza] CredencialApplicationService - buscaCredencialPorEmail");
        return credencial;
    }
}
