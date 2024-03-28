package com.AdvogaSystem.usuario.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Usuário")
@RestController
@RequestMapping("/public/v1/usuario/{idAdvocacia}")
public interface UsuarioAPI {
    @PostMapping("/novo-usuario")
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Cadastra novo Usuário")
    UsuarioCriadoResponse postCadastraNovoUsuario(@Valid @RequestBody UsuarioRequest usuarioNovoRequest,
                                                  @RequestHeader(name = "Authorization") String token,
                                                  @PathVariable UUID idAdvocacia);
}
