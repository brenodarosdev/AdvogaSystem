package com.AdvogaSystem.authentication.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Token {
    private String token;
    private String tipo;

    public Token(String token, String tipo) {
        this.token = token;
        this.tipo = tipo;
    }
}
