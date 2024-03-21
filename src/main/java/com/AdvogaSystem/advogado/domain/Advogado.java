package com.AdvogaSystem.advogado.domain;

import com.AdvogaSystem.advogado.application.api.AdvogadoRequest;
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
@Document(collection = "advogado")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Advogado {
    @Id
    private UUID idAdvogado;
    @NotBlank(message = "O email não pode estar em branco")
    @Email(message = "Este campo deve conter um email")
    @Indexed(unique = true)
    private String email;
    @NotBlank(message = "Este campo não pode estar em branco")
    private String nomeCompleto;

    public Advogado(AdvogadoRequest advogadoRequest) {
        this.idAdvogado = UUID.randomUUID();
        this.email = advogadoRequest.getEmail();
        this.nomeCompleto = advogadoRequest.getNomeCompleto();
    }
}
