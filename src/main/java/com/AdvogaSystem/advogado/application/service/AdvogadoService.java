package com.AdvogaSystem.advogado.application.service;

import com.AdvogaSystem.advogado.application.api.AdvogadoCriadoResponse;
import com.AdvogaSystem.advogado.application.api.AdvogadoRequest;

public interface AdvogadoService {
    AdvogadoCriadoResponse cadastraNovoAdvogado(AdvogadoRequest advogadoNovoRequest);
}
