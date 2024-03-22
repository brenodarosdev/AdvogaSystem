package com.AdvogaSystem.advocacia.infra;

import com.AdvogaSystem.advocacia.application.repository.AdvocaciaRepository;
import com.AdvogaSystem.advocacia.domain.Advocacia;
import com.AdvogaSystem.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.Store;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
@RequiredArgsConstructor
public class AdvocaciaInfraRepository implements AdvocaciaRepository {
    private final AdvocaciaSpringDataMongoDBRepository advocaciaSpringDataMongoDBRepository;

    @Override
    public Advocacia salva(Advocacia advocacia) {
        log.info("[inicia] AdvocaciaInfraRepository - salva");
        try {
            Advocacia advocaciaSalva = advocaciaSpringDataMongoDBRepository.save(advocacia);
            log.info("[finaliza] AdvocaciaInfraRepository - salva");
            return advocaciaSalva;
        } catch (DataIntegrityViolationException e) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Já existe uma advocacia cadastrada com este email!");
        }
    }
}
