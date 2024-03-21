package com.AdvogaSystem.advogado.application.repository;

import com.AdvogaSystem.advogado.application.api.AdvogadoCriadoResponse;
import com.AdvogaSystem.advogado.application.api.AdvogadoRequest;
import com.AdvogaSystem.advogado.domain.Advogado;

public interface AdvogadoRepository {
    Advogado salva(Advogado advogado);
}
