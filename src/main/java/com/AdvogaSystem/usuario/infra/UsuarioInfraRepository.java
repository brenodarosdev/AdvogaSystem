package com.AdvogaSystem.usuario.infra;

import com.AdvogaSystem.handler.APIException;
import com.AdvogaSystem.usuario.application.repository.UsuarioRepository;
import com.AdvogaSystem.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.Store;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
@RequiredArgsConstructor
public class UsuarioInfraRepository implements UsuarioRepository {
    private final UsuarioSpringDataMongDBRepository usuarioSpringDataMongDBRepository;

    @Override
    public Usuario salva(Usuario usuario) {
        log.info("[inicia] UsuarioInfraRepository - salva");
        try {
            log.info("[finaliza] UsuarioInfraRepository - salva");
            Usuario usuarioSalvo = usuarioSpringDataMongDBRepository.save(usuario);
            return usuarioSalvo;
        } catch (DataIntegrityViolationException e) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Já existe um Usuário cadastrado com este telefone");
        }
    }
}
