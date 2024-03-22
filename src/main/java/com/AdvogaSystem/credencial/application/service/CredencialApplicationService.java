package com.AdvogaSystem.credencial.application.service;

import com.AdvogaSystem.advocacia.application.api.AdvocaciaRequest;
import com.AdvogaSystem.credencial.application.repository.CredencialRepository;
import com.AdvogaSystem.credencial.domain.Credencial;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class CredencialApplicationService implements CredencialService {
    private final CredencialRepository credencialRepository;

    @Override
    public void criaNovaCredencial(AdvocaciaRequest advocaciaNovoRequest) {
        log.info("[inicia] CredencialApplicationService - criaNovaCredencial");
        credencialRepository.salva(new Credencial(advocaciaNovoRequest.getEmail(), advocaciaNovoRequest.getSenha()));
        log.info("[finaliza] CredencialApplicationService - criaNovaCredencial");
    }

    @Override
    public Credencial buscaCredencialPorEmail(String email) {
        log.info("[inicia] CredencialApplicationService - buscaCredencialPorEmail");
        Credencial credencial = credencialRepository.buscaCredencialPorEmail(email);
        log.info("[finaliza] CredencialApplicationService - buscaCredencialPorEmail");
        return credencial;
    }
}
