package com.ifsul.aproximei.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifsul.aproximei.dto.usuario.UsuarioCreateDTO;
import com.ifsul.aproximei.dto.usuario.UsuarioDTO;
import com.ifsul.aproximei.entity.Usuario;
import com.ifsul.aproximei.entity.enums.TipoUsuario;
import com.ifsul.aproximei.exceptions.RegraDeNegocioException;
import com.ifsul.aproximei.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginService {

    private final UsuarioRepository usuarioRepository;
    private final ObjectMapper objectMapper;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UsuarioDTO createUsuario(UsuarioCreateDTO usuarioCreateDTO) throws RegraDeNegocioException {
        if (usuarioRepository.findByEmailUsuario(usuarioCreateDTO.getEmailUsuario()).isPresent()) {
            throw new RegraDeNegocioException("Usuário já cadastrado com este email! Por favor, faça login.");
        }

        Usuario usuarioCriado = objectMapper.convertValue(usuarioCreateDTO, Usuario.class);

        usuarioCriado.setSenha(passwordEncoder.encode(usuarioCreateDTO.getSenha()));

        usuarioCriado.setRole(TipoUsuario.PRESTADOR);

        Usuario usuarioSalvo = usuarioRepository.save(usuarioCriado);

        return objectMapper.convertValue(usuarioSalvo, UsuarioDTO.class);
    }

    public Optional<Usuario> findByEmailUsuario(String email) {
        return usuarioRepository.findByEmailUsuario(email);
    }

    public void atualizarUltimoLogin(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

}

