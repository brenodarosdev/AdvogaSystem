package com.AdvogaSystem.config.security.service;

import com.AdvogaSystem.credencial.application.repository.CredencialRepository;
import com.AdvogaSystem.credencial.domain.Credencial;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class AuthenticationSecurityService implements UserDetailsService {
    private final CredencialRepository credencialRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("[inicia] AuthenticationSecurityService - buscaCredencialPorEmail");
        Credencial credencial = credencialRepository.buscaCredencialPorEmail(email);
        log.info("[finaliza] AuthenticationSecurityService - buscaCredencialPorEmail");
        return credencial;
    }
}
