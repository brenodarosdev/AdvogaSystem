package com.AdvogaSystem.advocacia.application.repository;

import com.AdvogaSystem.advocacia.domain.Advocacia;

import java.util.UUID;

public interface AdvocaciaRepository {
    Advocacia salva(Advocacia advocacia);
    Advocacia advocaciaPorEmail(String emailAdvocacia);
    Advocacia advocaciaPorId(UUID idAdvocacia);
}
