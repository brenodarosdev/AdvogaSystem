package com.AdvogaSystem.usuario.infra;

import com.AdvogaSystem.usuario.domain.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface UsuarioSpringDataMongDBRepository extends MongoRepository<Usuario, UUID> {
}
