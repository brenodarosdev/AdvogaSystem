package com.AdvogaSystem.advogado.infra;

import com.AdvogaSystem.advogado.application.api.AdvogadoCriadoResponse;
import com.AdvogaSystem.advogado.application.api.AdvogadoRequest;
import com.AdvogaSystem.advogado.application.repository.AdvogadoRepository;
import com.AdvogaSystem.advogado.domain.Advogado;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
public class AdvogadoInfraRepository implements AdvogadoRepository {
    @Override
    public Advogado salva(Advogado advogado) {
        log.info("[inicia] AdvogadoInfraRepository - salva");
        log.info("[finaliza] AdvogadoInfraRepository - salva");
        return null;
    }
}
