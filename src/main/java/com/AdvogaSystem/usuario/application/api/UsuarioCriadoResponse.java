package com.AdvogaSystem.usuario.application.api;

import com.AdvogaSystem.usuario.domain.Usuario;
import lombok.Value;

import java.util.UUID;

@Value
public class UsuarioCriadoResponse {
    UUID idUsuario;

    public UsuarioCriadoResponse(Usuario usuario) {
        this.idUsuario = usuario.getIdUsuario();
    }
}
