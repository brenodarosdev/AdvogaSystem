package com.AdvogaSystem.advocacia.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Advocacia")
@RestController
@RequestMapping("/public/v1/advocacia")
public interface AdvocaciaAPI {
    @PostMapping("/nova-advocacia")
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Cadastra nova Advocacia")
    AdvocaciaCriadaResponse postCadastraNovaAdvocacia(@Valid @RequestBody AdvocaciaRequest advocaciaNovoRequest);
}
