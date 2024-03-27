package com.AdvogaSystem.usuario.application.api;

import com.AdvogaSystem.config.security.service.TokenService;
import com.AdvogaSystem.handler.APIException;
import com.AdvogaSystem.usuario.application.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Log4j2
@RestController
@RequiredArgsConstructor
public class UsuarioController implements UsuarioAPI {
    private final UsuarioService usuarioService;
    private final TokenService tokenService;


    @Override
    public UsuarioCriadoResponse postCadastraNovoUsuario(UsuarioRequest usuarioNovoRequest, String token, UUID idAdvocacia) {
        log.info("[inicia] UsuarioController - postCadastraNovoUsuario");
        String emailAdvocacia = tokenService.getEmailByBearerToken(token)
                .orElseThrow(() -> APIException.build(HttpStatus.UNAUTHORIZED, "Token inválido!"));
        UsuarioCriadoResponse usuarioCriadoResponse = usuarioService
                .cadastraNovoUsuario(usuarioNovoRequest, emailAdvocacia, idAdvocacia);
        log.info("[finaliza] UsuarioController - postCadastraNovoUsuario");
        return usuarioCriadoResponse;
    }
}
