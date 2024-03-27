package com.AdvogaSystem.advocacia.application.api;

import com.AdvogaSystem.advocacia.application.service.AdvocaciaService;
import com.AdvogaSystem.config.security.service.TokenService;
import com.AdvogaSystem.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Log4j2
@RestController
@RequiredArgsConstructor
public class AdvocaciaController implements AdvocaciaAPI {
    private final AdvocaciaService advocaciaService;
    private final TokenService tokenService;

    @Override
    public AdvocaciaCriadaResponse postCadastraNovaAdvocacia(AdvocaciaRequest advocaciaNovoRequest) {
        log.info("[inicia] AdvocaciaController - postCadastraNovaAdvocacia");
        AdvocaciaCriadaResponse advocaciaCriadaResponse = advocaciaService.cadastraNovaAdvocacia(advocaciaNovoRequest);
        log.info("[finaliza] AdvocaciaController - postCadastraNovaAdvocacia");
        return advocaciaCriadaResponse;
    }

    @Override
    public AdvocaciaDetalhadaResponse getBuscaAdvocaciaPorId(String token, UUID idAdvocacia) {
        log.info("[inicia] AdvocaciaController - getBuscaAdvocaciaPorId");
        String emailAdvocacia = tokenService.getEmailByBearerToken(token)
                .orElseThrow(() -> APIException.build(HttpStatus.UNAUTHORIZED, "Token inválido!"));
        AdvocaciaDetalhadaResponse advocaciaDetalhadaResponse = advocaciaService.buscaAdvocaciaPorId(emailAdvocacia, idAdvocacia);
        log.info("[finaliza] AdvocaciaController - getBuscaAdvocaciaPorId");
        return advocaciaDetalhadaResponse;
    }

    @Override
    public void patchAlteraAdvocacia(String token, UUID idAdvocacia, AdvocaciaRequest alteraAdvocaciaRequest) {
        log.info("[inicia] AdvocaciaController - patchAlteraAdvocacia");
        String emailAdvocacia = tokenService.getEmailByBearerToken(token)
                .orElseThrow(() -> APIException.build(HttpStatus.UNAUTHORIZED, "Token inválido!"));
        advocaciaService.alteraAdvocacia(emailAdvocacia, idAdvocacia, alteraAdvocaciaRequest);
        log.info("[finaliza] AdvocaciaController - patchAlteraAdvocacia");
    }

    @Override
    public void deleteDeletaAdvocacia(String token, UUID idAdvocacia) {
        log.info("[inicia] AdvocaciaController - deleteDeletaAdvocacia");
        String emailAdvocacia = tokenService.getEmailByBearerToken(token)
                .orElseThrow(() -> APIException.build(HttpStatus.UNAUTHORIZED, "Token inválido!"));
        advocaciaService.deletaAdvocacia(emailAdvocacia, idAdvocacia);
        log.info("[finaliza] AdvocaciaController - deleteDeletaAdvocacia");
    }
}
