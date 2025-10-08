package com.ifsul.aproximei.controller;

import com.ifsul.aproximei.dto.usuario.UsuarioCreateDTO;
import com.ifsul.aproximei.dto.usuario.UsuarioDTO;
import com.ifsul.aproximei.dto.usuario.UsuarioLoginDTO;
import com.ifsul.aproximei.entity.Usuario;
import com.ifsul.aproximei.exceptions.RegraDeNegocioException;
import com.ifsul.aproximei.security.TokenService;
import com.ifsul.aproximei.service.LoginService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
@Tag(name = "Login Controller")
public class LoginController {

    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final LoginService loginService;

    @PostMapping("/usuario")
    public ResponseEntity<String> login(@RequestBody @Valid UsuarioLoginDTO loginDTO) {
        try {
            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getSenha());

            Authentication authentication = authenticationManager.authenticate(authToken);

            Usuario usuarioValidado = (Usuario) authentication.getPrincipal();

            usuarioValidado.setUltimoLogin(LocalDateTime.now());
            loginService.atualizarUltimoLogin(usuarioValidado);

            String token = tokenService.generateToken(usuarioValidado);

            return ResponseEntity.ok(token);
        } catch (AuthenticationException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou Senha Incorretos!");
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody @Valid UsuarioCreateDTO usuarioCreateDTO) throws RegraDeNegocioException {
        UsuarioDTO usuarioCriado = loginService.createUsuario(usuarioCreateDTO);
        return new ResponseEntity<>(usuarioCriado, HttpStatus.OK);
    }
}
