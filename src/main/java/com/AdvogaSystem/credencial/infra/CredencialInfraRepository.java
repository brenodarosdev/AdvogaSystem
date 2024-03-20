package com.AdvogaSystem.credencial.infra;

import com.AdvogaSystem.credencial.application.repository.CredencialRepository;
import com.AdvogaSystem.credencial.domain.Credencial;
import com.AdvogaSystem.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
@Log4j2
public class CredencialInfraRepository implements CredencialRepository {
    private final CredencialSpringDataMongoDBRepository credencialSpringDataMongoDBRepository;
    @Override
    public Credencial buscaCredencialPorEmail(String email) {
        log.info("[inicia] CredencialInfraRepository - buscaCredencialPorEmail");
        Credencial credencial = credencialSpringDataMongoDBRepository.findByEmail(email)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Não existe credencial para o Email informado!"));
        log.info("[finaliza] CredencialInfraRepository - buscaCredencialPorEmail");
        return credencial;
    }
}
