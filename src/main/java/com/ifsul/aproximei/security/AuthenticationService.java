package com.ifsul.aproximei.security;

import com.ifsul.aproximei.entity.Usuario;
import com.ifsul.aproximei.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {
    private final LoginService loginService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioEntityOptional = loginService.findByEmailUsuario(username);
        if (usuarioEntityOptional.isPresent()) {
            return usuarioEntityOptional.get();
        }

        throw new UsernameNotFoundException("Usuário inválido");
    }
}
