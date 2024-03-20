package com.AdvogaSystem.credencial.application.service;

import com.AdvogaSystem.credencial.domain.Credencial;

public interface CredencialService {
    Credencial buscaCredencialPorEmail(String email);
}
