package com.AdvogaSystem.usuario.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Value;
import org.springframework.data.mongodb.core.index.Indexed;

@Value
public class UsuarioRequest {
    @NotBlank(message = "O campo Nome completo não pode estar em branco!")
    String nomeCompleto;
    @Size(min = 10, max = 11, message = "O campo telefone deve ter entre 10 e 11 caracteres")
    @Indexed(unique = true)
    @NotBlank(message = "O campo Telefone não pode estar em branco!")
    String numeroDeTelefone;
    @NotBlank(message = "O campo senha não pode estar em branco")
    @Size(min = 8, max = 20, message = "O campo senha deve ter de 8 a 20 caracteres")
    private String senha;
}
