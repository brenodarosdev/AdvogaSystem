package com.AdvogaSystem.usuario.application.service;

import com.AdvogaSystem.usuario.application.api.UsuarioCriadoResponse;
import com.AdvogaSystem.usuario.application.api.UsuarioRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Log4j2
@Service
public class UsuarioApplicationService implements UsuarioService {
    @Override
    public UsuarioCriadoResponse cadastraNovoUsuario(UsuarioRequest usuarioNovoRequest, String emailAdvocacia, UUID idAdvocacia) {
        log.info("[inicia] UsuarioApplicationService - cadastraNovoUsuario");
        log.info("[finaliza] UsuarioApplicationService - cadastraNovoUsuario");
        return null;
    }
}
