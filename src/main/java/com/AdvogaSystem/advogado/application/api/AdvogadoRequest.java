package com.AdvogaSystem.advogado.application.api;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Value;
import org.springframework.data.mongodb.core.index.Indexed;

@Value
public class AdvogadoRequest {
    @NotBlank(message = "O email não pode estar em branco")
    @Email(message = "Este campo deve conter um email")
    @Indexed(unique = true)
    private String email;
    @Size(min = 8, max = 20, message = "A senha deve ter de 8 a 20 caracteres")
    @NotBlank(message = "Este campo não pode estar em branco")
    private String senha;
    @NotBlank(message = "Este campo não pode estar em branco")
    private String nomeCompleto;
}
