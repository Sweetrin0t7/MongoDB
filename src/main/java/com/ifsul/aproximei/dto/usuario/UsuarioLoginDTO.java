package com.ifsul.aproximei.dto.usuario;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioLoginDTO {

    @NotBlank
    @Email
    @Schema(description = "Email do usuário", example = "renata@email.com", required = true)
    private String email;

    @NotBlank
    @Schema(description = "Senha do usuário", example = "senha@123", required = true)
    private String senha;
}
