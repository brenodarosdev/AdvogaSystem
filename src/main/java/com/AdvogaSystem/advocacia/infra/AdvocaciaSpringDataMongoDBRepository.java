package com.AdvogaSystem.advocacia.infra;

import com.AdvogaSystem.advocacia.domain.Advocacia;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface AdvocaciaSpringDataMongoDBRepository extends MongoRepository<Advocacia, UUID> {
    Optional<Advocacia> findByEmail(String emailAdvocacia);
    Optional<Advocacia> findByIdAdvocacia(UUID idAdvocacia);
}
