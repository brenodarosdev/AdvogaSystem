package com.AdvogaSystem.advocacia.application.service;

import com.AdvogaSystem.advocacia.application.api.AdvocaciaCriadaResponse;
import com.AdvogaSystem.advocacia.application.api.AdvocaciaRequest;

public interface AdvocaciaService {
    AdvocaciaCriadaResponse cadastraNovaAdvocacia(AdvocaciaRequest advocaciaNovoRequest);
}
