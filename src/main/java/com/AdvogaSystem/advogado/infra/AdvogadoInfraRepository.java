package com.AdvogaSystem.advogado.infra;

import com.AdvogaSystem.advogado.application.api.AdvogadoCriadoResponse;
import com.AdvogaSystem.advogado.application.api.AdvogadoRequest;
import com.AdvogaSystem.advogado.application.repository.AdvogadoRepository;
import com.AdvogaSystem.advogado.domain.Advogado;
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
public class AdvogadoInfraRepository implements AdvogadoRepository {
    private final AdvogadoSpringDataMongoDBRepository advogadoSpringDataMongoDBRepository;

    @Override
    public Advogado salva(Advogado advogado) {
        log.info("[inicia] AdvogadoInfraRepository - salva");
        try {
            Advogado advogadoSalvo = advogadoSpringDataMongoDBRepository.save(advogado);
            log.info("[finaliza] AdvogadoInfraRepository - salva");
            return advogadoSalvo;
        } catch (DataIntegrityViolationException e) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Já existe um advogado cadastrado com este email!");
        }
    }
}
