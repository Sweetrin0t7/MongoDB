package com.ifsul.aproximei.entity.enums;

public enum TipoUsuario {
    ADMIN("ADMIN"),
    PRESTADOR("PRESTADOR");

    private final String role;

    TipoUsuario(String role) {
        this.role = role;
    }

    public String getRoleName() {
        return "ROLE_" + this.role;
    }

    public String getRole() {
        return role;
    }

    public static TipoUsuario fromRole(String role) {
        for (TipoUsuario tipoUsuario : TipoUsuario.values()) {
            if (tipoUsuario.getRole().equalsIgnoreCase(role)) {
                return tipoUsuario;
            }
        }
        throw new IllegalArgumentException("Valor inválido para a enumeração TipoUsuario: " + role);
    }
}
