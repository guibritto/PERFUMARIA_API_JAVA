package br.com.fiap.api_rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PerfumariaRequest(
        @NotBlank(message = "O nome da perfumaria é obrigatório") String nome,
        @NotNull(message = "O endereço da perfumaria é obrigatório") String localizacao
) {
}
