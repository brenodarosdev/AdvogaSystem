package com.AdvogaSystem.advocacia.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Advocacia")
@RestController
@RequestMapping("/public/v1/advocacia")
public interface AdvocaciaAPI {
    @PostMapping("/nova-advocacia")
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Cadastra nova Advocacia")
    AdvocaciaCriadaResponse postCadastraNovaAdvocacia(@Valid @RequestBody AdvocaciaRequest advocaciaNovoRequest);

    @GetMapping("/busca-advocacia/{idAdvocacia}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Busca Advocacia")
    AdvocaciaDetalhadaResponse getBuscaAdvocaciaPorId(@RequestHeader(name = "Authorization") String token,
                                                      @PathVariable UUID idAdvocacia);

    @PatchMapping("/edita-advocacia/{idAdvocacia}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Altera Advocacia")
    void patchAlteraAdvocacia(@RequestHeader(name = "Authorization") String token, @PathVariable UUID idAdvocacia,
                              @RequestBody @Valid AdvocaciaRequest alteraAdvocaciaRequest);

    @DeleteMapping("/deleta-advocacia/{idAdvocacia}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Deleta Advocacia")
    void deleteDeletaAdvocacia(@RequestHeader(name = "Authorization") String token, @PathVariable UUID idAdvocacia);
}
