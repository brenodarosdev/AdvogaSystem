package com.AdvogaSystem.advocacia.infra;

import com.AdvogaSystem.advocacia.application.repository.AdvocaciaRepository;
import com.AdvogaSystem.advocacia.domain.Advocacia;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
public class AdvocaciaInfraRepository implements AdvocaciaRepository {
    @Override
    public Advocacia salva(Advocacia advocacia) {
        log.info("[inicia] AdvocaciaInfraRepository - salva");
        log.info("[finaliza] AdvocaciaInfraRepository - salva");
        return null;
    }
}
