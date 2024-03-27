package com.AdvogaSystem.usuario.application.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Log4j2
@RestController
public class UsuarioController implements UsuarioAPI {
    @Override
    public UsuarioCriadoResponse postCadastraNovoUsuario(UsuarioRequest usuarioNovoRequest, String token, UUID idAdvocacia) {
        log.info("[inicia] UsuarioController - postCadastraNovoUsuario");
        log.info("[finaliza] UsuarioController - postCadastraNovoUsuario");
        return null;
    }
}
