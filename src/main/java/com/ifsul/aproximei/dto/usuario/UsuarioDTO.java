package com.ifsul.aproximei.dto.usuario;

import com.ifsul.aproximei.entity.enums.TipoUsuario;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class UsuarioDTO {

    private Integer idUsuario;
    private String nomeUsuario;
    private String emailUsuario;
    private Boolean ativo;
    private LocalDateTime criadoEm;
    private TipoUsuario role;

}
