package com.AdvogaSystem.credencial.infra;

import com.AdvogaSystem.credencial.domain.Credencial;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CredencialSpringDataMongoDBRepository extends MongoRepository<Credencial, String> {
    Optional<Credencial> findByEmail(String email);
}
