package com.AdvogaSystem.advogado.infra;

import com.AdvogaSystem.advogado.domain.Advogado;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface AdvogadoSpringDataMongoDBRepository extends MongoRepository<Advogado, UUID> {
}
