package com.AdvogaSystem.advocacia.application.api;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Value;
import org.springframework.data.mongodb.core.index.Indexed;

@Value
public class AdvocaciaRequest {
    @Email(message = "Este campo deve conter um email")
    @Indexed(unique = true)
    @NotBlank(message = "O campo email não pode estar em branco")
    private String email;
    @NotBlank(message = "O campo senha não pode estar em branco")
    @Size(min = 8, max = 20, message = "O campo senha deve ter de 8 a 20 caracteres")
    private String senha;
    @NotBlank(message = "O campo nome da advocacia não pode estar em branco")
    private String nomeDaAdvocacia;
}
