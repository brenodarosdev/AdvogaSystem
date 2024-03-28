package com.AdvogaSystem.usuario.application.service;

import com.AdvogaSystem.advocacia.application.repository.AdvocaciaRepository;
import com.AdvogaSystem.advocacia.domain.Advocacia;
import com.AdvogaSystem.credencial.application.service.CredencialService;
import com.AdvogaSystem.usuario.application.api.UsuarioCriadoResponse;
import com.AdvogaSystem.usuario.application.api.UsuarioRequest;
import com.AdvogaSystem.usuario.application.repository.UsuarioRepository;
import com.AdvogaSystem.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class UsuarioApplicationService implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Override
    public UsuarioCriadoResponse cadastraNovoUsuario(UsuarioRequest usuarioNovoRequest, String emailAdvocacia, UUID idAdvocacia) {
        log.info("[inicia] UsuarioApplicationService - cadastraNovoUsuario");
        Usuario usuario = usuarioRepository.salva(new Usuario(usuarioNovoRequest, idAdvocacia));
        log.info("[finaliza] UsuarioApplicationService - cadastraNovoUsuario");
        return new UsuarioCriadoResponse(usuario);
    }
}
