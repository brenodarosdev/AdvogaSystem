package com.AdvogaSystem.authentication.application.service;

import com.AdvogaSystem.authentication.domain.Token;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface AuthenticationService {
    Token autentica(UsernamePasswordAuthenticationToken userPassToken);
}
