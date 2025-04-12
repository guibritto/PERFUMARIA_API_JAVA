package br.com.fiap.api_rest.dto;

// Record utilizado para representar o retorno (DTO) da entidade Perfumaria na API.
// É imutável e mais conciso que uma classe tradicional.
public record PerfumariaResponse(
        Long id,           // ID da perfumaria
        String nome,       // Nome da perfumaria
        String localizacao // Localização da perfumaria
) {
    // Não precisa de métodos extras aqui (getters são automáticos: .id(), .nome(), .localizacao())
}
