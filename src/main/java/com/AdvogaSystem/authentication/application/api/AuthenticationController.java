package com.AdvogaSystem.authentication.application.api;

import com.AdvogaSystem.authentication.application.service.AuthenticationService;
import com.AdvogaSystem.authentication.domain.Token;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class AuthenticationController implements AuthenticationAPI {
    private final AuthenticationService authenticationService;

    @Override
    public TokenResponse autenticaAdvocacia(AuthenticationRequest authenticationRequest) {
        log.info("[inicia] AuthenticationController - autenticaAdvocacia");
        Token token = authenticationService.autentica(authenticationRequest.getUserPassToken());
        log.info("[finaliza] AuthenticationController - autenticaAdvocacia");
        return new TokenResponse(token);
    }
}
