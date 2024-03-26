package com.AdvogaSystem.advocacia.application.service;

import com.AdvogaSystem.advocacia.application.api.AdvocaciaCriadaResponse;
import com.AdvogaSystem.advocacia.application.api.AdvocaciaDetalhadaResponse;
import com.AdvogaSystem.advocacia.application.api.AdvocaciaRequest;

import java.util.UUID;

public interface AdvocaciaService {
    AdvocaciaCriadaResponse cadastraNovaAdvocacia(AdvocaciaRequest advocaciaNovoRequest);
    AdvocaciaDetalhadaResponse buscaAdvocaciaPorId(String emailAdvocacia, UUID idAdvocacia);
}
