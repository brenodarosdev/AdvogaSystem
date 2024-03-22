package com.AdvogaSystem.credencial.application.service;

import com.AdvogaSystem.advocacia.application.api.AdvocaciaRequest;
import com.AdvogaSystem.credencial.domain.Credencial;

public interface CredencialService {
    void criaNovaCredencial(AdvocaciaRequest advocaciaNovoRequest);
    Credencial buscaCredencialPorEmail(String email);
}
