package com.ifsul.aproximei.dto.usuario;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
@Schema(description = "Objeto de retorno com o token JWT")
public class TokenDTO {

    @Schema(description = "Token JWT gerado para o usuário", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
    private String token;
}

