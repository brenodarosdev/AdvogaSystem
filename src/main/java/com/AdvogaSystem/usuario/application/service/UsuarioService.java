package com.AdvogaSystem.usuario.application.service;

import com.AdvogaSystem.usuario.application.api.UsuarioCriadoResponse;
import com.AdvogaSystem.usuario.application.api.UsuarioRequest;

import java.util.UUID;

public interface UsuarioService {
    UsuarioCriadoResponse cadastraNovoUsuario(UsuarioRequest usuarioNovoRequest, String emailAdvocacia, UUID idAdvocacia);
}
