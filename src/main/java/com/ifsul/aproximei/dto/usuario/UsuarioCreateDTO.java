package com.ifsul.aproximei.dto.usuario;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioCreateDTO {

    @NotBlank
    @Schema(description = "Nome do usuário", example = "Renata Oliveira", required = true)
    private String nomeUsuario;

    @NotBlank
    @Email
    @Schema(description = "Email do usuário", example = "renata@email.com", required = true)
    private String emailUsuario;

    @NotBlank
    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
    @Pattern(regexp = "^(?=.*[!@#$%^&*(),.?\":{}|<>]).*$", message = "A senha deve conter pelo menos 1 caractere especial")
    @Schema(description = "Senha do usuário", example = "senha@123", required = true)
    private String senha;

    @NotBlank
    @Schema(description = "Telefone do prestador", example = "51999999999", required = true)
    private String telefone;
}
