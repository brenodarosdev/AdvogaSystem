package com.AdvogaSystem.credencial.application.repository;

import com.AdvogaSystem.credencial.domain.Credencial;

public interface CredencialRepository {
    Credencial salva(Credencial credencial);
    Credencial buscaCredencialPorEmail(String email);
}
