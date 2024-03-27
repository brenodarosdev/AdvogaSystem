package com.AdvogaSystem.usuario.infra;

import com.AdvogaSystem.usuario.application.repository.UsuarioRepository;
import com.AdvogaSystem.usuario.domain.Usuario;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
public class UsuarioInfraRepository implements UsuarioRepository {
    @Override
    public Usuario salva(Usuario usuario) {
        log.info("[inicia] UsuarioInfraRepository - salva");
        log.info("[finaliza] UsuarioInfraRepository - salva");
        return null;
    }
}
