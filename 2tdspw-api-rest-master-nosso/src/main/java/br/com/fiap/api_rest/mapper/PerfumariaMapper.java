package br.com.fiap.api_rest.mapper;

import br.com.fiap.api_rest.dto.PerfumariaRequest;
import br.com.fiap.api_rest.dto.PerfumariaResponse;
import br.com.fiap.api_rest.model.Perfumaria;
import org.springframework.stereotype.Component;

@Component
public class PerfumariaMapper {

    // Converte um PerfumariaRequest (DTO) para a entidade Perfumaria
    public Perfumaria requestToPerfumaria(PerfumariaRequest perfumariaRequest) {
        Perfumaria perfumaria = new Perfumaria();
        // Define o nome e localização com base no que veio do DTO
        perfumaria.setNome(perfumariaRequest.nome());
        perfumaria.setLocalizacao(perfumariaRequest.localizacao());
        return perfumaria;
    }

    // Converte uma entidade Perfumaria para o PerfumariaResponse (DTO de saída)
    public PerfumariaResponse perfumariaToResponse(Perfumaria perfumaria) {
        return new PerfumariaResponse(
                perfumaria.getId(),           // ID da perfumaria
                perfumaria.getNome(),         // Nome da perfumaria
                perfumaria.getLocalizacao()   // Localização da perfumaria
        );
    }
}
