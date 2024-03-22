package com.AdvogaSystem.authentication.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "Autenticação")
@RequestMapping("/public/v1/autentica")
public interface AuthenticationAPI {
    @PostMapping("/advocacia")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Autentica Advocacia")
    TokenResponse autenticaAdvocacia(@RequestBody @Valid AuthenticationRequest authenticationRequest);
}
