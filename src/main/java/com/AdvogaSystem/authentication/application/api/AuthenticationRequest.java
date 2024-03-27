package com.AdvogaSystem.authentication.application.api;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Value
public class AuthenticationRequest {
    @NotBlank(message = "O email não pode estar em branco!")
    private String email;
    @NotBlank(message = "A senha não pode estar em branco!")
    private String senha;

    public UsernamePasswordAuthenticationToken getUserPassToken() {
        return new UsernamePasswordAuthenticationToken(email, senha);
    }
}
