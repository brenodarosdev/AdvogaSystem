package com.AdvogaSystem.usuario.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Document(collection = "usuario")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Usuario {
    @Id
    UUID idUsuario;
    @Indexed
    UUID idAdvocacia;
    @NotBlank(message = "O campo Nome completo não pode estar em branco!")
    String nomeCompleto;
    @Size(min = 10, max = 11, message = "O campo telefone deve ter entre 10 e 11 caracteres")
    @Indexed(unique = true)
    @NotBlank(message = "O campo Telefone não pode estar em branco!")
    String numeroDeTelefone;

    public Usuario(UUID idAdvocacia, String nomeCompleto, String numeroDeTelefone) {
        this.idUsuario = UUID.randomUUID();
        this.idAdvocacia = idAdvocacia;
        this.nomeCompleto = nomeCompleto;
        this.numeroDeTelefone = numeroDeTelefone;
    }
}
