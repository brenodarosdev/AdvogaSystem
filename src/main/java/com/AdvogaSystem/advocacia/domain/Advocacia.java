package com.AdvogaSystem.advocacia.domain;

import com.AdvogaSystem.advocacia.application.api.AdvocaciaRequest;
import com.AdvogaSystem.handler.APIException;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;

import java.util.UUID;

@Getter
@Document(collection = "advocacia")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Advocacia {
    @Id
    private UUID idAdvocacia;
    @Email(message = "Este campo deve conter um email")
    @Indexed(unique = true)
    @NotBlank(message = "O campo email não pode estar em branco")
    private String email;
    @NotBlank(message = "O campo nome da advocacia não pode estar em branco")
    private String nomeDaAdvocacia;

    public Advocacia(AdvocaciaRequest advocaciaRequest) {
        this.idAdvocacia = UUID.randomUUID();
        this.email = advocaciaRequest.getEmail();
        this.nomeDaAdvocacia = advocaciaRequest.getNomeDaAdvocacia();
    }

    public void validaAdvocacia(UUID idAdvocacia) {
        if (!this.idAdvocacia.equals(idAdvocacia)) {
            throw APIException.build(HttpStatus.UNAUTHORIZED, "O token fornecido não pertence a esta advocacia!");
        }
    }

    public void alteraAdvocacia(AdvocaciaRequest alteraAdvocaciaRequest) {
        this.email = alteraAdvocaciaRequest.getEmail();
        this.nomeDaAdvocacia = alteraAdvocaciaRequest.getNomeDaAdvocacia();
    }
}
