package com.AdvogaSystem.credencial.application.repository;

import com.AdvogaSystem.credencial.domain.Credencial;

public interface CredencialRepository {
    Credencial salva(Credencial novaCredencial);
    Credencial buscaCredencialPorEmail(String email);
}
