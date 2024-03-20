package com.AdvogaSystem.config.security;

import com.AdvogaSystem.config.security.domain.ValidaConteudoAuthorizationHeader;
import com.AdvogaSystem.config.security.service.TokenService;
import com.AdvogaSystem.credencial.application.service.CredencialService;
import com.AdvogaSystem.credencial.domain.Credencial;
import com.AdvogaSystem.handler.APIException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Log4j2
@RequiredArgsConstructor
public class FiltroToken extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final CredencialService credencialService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        log.info("[inicia] Filtro - filtrando requisição");
        String token = recuperaToken(request);
        autenticaUsuario(token);
        log.info("[finaliza] Filtro - filtrando requisição");
        filterChain.doFilter(request, response);
    }

    private void autenticaUsuario(String token) {
        log.info("[inicia] autenticaUsuario - utilizando token válido para autenticar o email");
        Credencial credencial = recuperaEmail(token);
        var authenticationToken = new UsernamePasswordAuthenticationToken(credencial, null, credencial.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        log.info("[finaliza] autenticaUsuario - utilizando token válido para autenticar o email");
    }

    private Credencial recuperaEmail(String token) {
        var email = tokenService.getEmail(token)
                .orElseThrow(()-> APIException.build(HttpStatus.FORBIDDEN, "O Token enviado está inválido. Tente novamente!"));
        return credencialService.buscaCredencialPorEmail(email);
    }

    private String recuperaToken(HttpServletRequest requestOpt) {
        log.info("[inicia] recuperaToken - extraindo o token dos cabecalhos da requisicao");
        var AuthorizationHeaderValueOpt = Optional.ofNullable(recuperaValorAuthorizationHeader(requestOpt));
        String AuthorizationHeaderValue = AuthorizationHeaderValueOpt.filter(new ValidaConteudoAuthorizationHeader())
                .orElseThrow(() -> APIException.build(HttpStatus.UNAUTHORIZED, "Token inválido!"));
        log.info("[finaliza] recuperaToken - extraindo o token dos cabecalhos da requisicao");
        return AuthorizationHeaderValue.substring(7, AuthorizationHeaderValue.length());
    }

    private String recuperaValorAuthorizationHeader(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader("Authorization"))
                .orElseThrow(() -> APIException.build(HttpStatus.FORBIDDEN, "Token não está presente na requisição!"));
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        return path.contains("/public/")||path.contains("/swagger-ui/");
    }
}
