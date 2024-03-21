package com.AdvogaSystem.authentication.application.api;

import com.AdvogaSystem.authentication.application.service.AuthenticationService;
import com.AdvogaSystem.authentication.domain.Token;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Log4j2
public class AuthenticationController implements AuthenticationAPI {
    private final AuthenticationService authenticationService;

    @Override
    public TokenResponse autenticaUsuario(AuthenticationRequest authenticationRequest) {
        log.info("[inicia] AuthenticationController - autenticaUsuario");
        Token token = authenticationService.autentica(authenticationRequest.getUserPassToken());
        log.info("[finaliza] AuthenticationController - autenticaUsuario");
        return new TokenResponse(token);
    }
}
