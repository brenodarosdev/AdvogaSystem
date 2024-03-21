package com.AdvogaSystem.advogado.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Advogado")
@RestController
@RequestMapping("/public/v1/advogado")
public interface AdvogadoAPI {
    @PostMapping("/novoAdvogado")
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Cria novo Advogado")
    AdvogadoCriadoResponse postCadastraNovoAdvogado(@RequestBody @Valid AdvogadoRequest advogadoNovoRequest);
}
