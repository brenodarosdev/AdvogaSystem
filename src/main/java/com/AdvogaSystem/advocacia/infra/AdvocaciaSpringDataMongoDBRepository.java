package com.AdvogaSystem.advocacia.infra;

import com.AdvogaSystem.advocacia.domain.Advocacia;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface AdvocaciaSpringDataMongoDBRepository extends MongoRepository<Advocacia, UUID> {
}
