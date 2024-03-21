package com.AdvogaSystem.advogado.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "advogado")
public class advogado {
    @Id
    private UUID idAdvogado;
    @NotBlank(message = "O email não pode estar em branco")
    @Email(message = "Este campo deve conter um email")
    @Indexed(unique = true)
    private String email;
    @NotBlank(message = "Este campo não pode estar em branco")
    private String nomeCompleto;

    public advogado(UUID idAdvogado, String email, String nomeCompleto) {
        this.idAdvogado = idAdvogado;
        this.email = email;
        this.nomeCompleto = nomeCompleto;
    }
}
