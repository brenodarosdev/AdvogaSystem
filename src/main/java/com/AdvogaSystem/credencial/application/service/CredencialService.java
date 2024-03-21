package com.AdvogaSystem.credencial.application.service;

import com.AdvogaSystem.advogado.application.api.AdvogadoRequest;
import com.AdvogaSystem.credencial.domain.Credencial;

public interface CredencialService {
    void criaNovaCredencial(AdvogadoRequest advogadoNovoRequest);

    Credencial buscaCredencialPorEmail(String email);
}
