package br.com.fiap.api_rest.service;

import br.com.fiap.api_rest.dto.PerfumariaRequest;
import br.com.fiap.api_rest.dto.PerfumariaResponse;
import br.com.fiap.api_rest.dto.ProdutoResponse;
import br.com.fiap.api_rest.mapper.PerfumariaMapper;
import br.com.fiap.api_rest.model.Perfumaria;
import br.com.fiap.api_rest.repository.PerfumariaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Indica que essa classe é um service do Spring (camada de regras de negócio)
public class PerfumariaService {

    private final PerfumariaRepository perfumariaRepository;
    private final PerfumariaMapper perfumariaMapper = new PerfumariaMapper(); // Mapeador pra converter entre entidade e DTO

    @Autowired
    public PerfumariaService(PerfumariaRepository perfumariaRepository){
        this.perfumariaRepository = perfumariaRepository;
    }

    // Salva uma nova perfumaria e retorna a versão em DTO de resposta
    public PerfumariaResponse save(PerfumariaRequest perfumariaRequest) {
        return perfumariaMapper.perfumariaToResponse(
                perfumariaRepository.save(perfumariaMapper.requestToPerfumaria(perfumariaRequest))
        );
    }



    // Busca todos os produtos no banco e converte para DTO de resposta
    public List<PerfumariaResponse> findAll() {
        return perfumariaRepository.findAll()
                .stream()
                .map(perfumariaMapper::perfumariaToResponse)
                .toList();
    }

    // Busca uma perfumaria pelo ID e retorna a entidade (usada internamente)
    public Perfumaria findPerfumariaById(Long id) {
        return perfumariaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Perfumaria com ID " + id + " não encontrada"));
    }

    // Busca uma perfumaria pelo ID e retorna a versão em DTO de resposta (usada externamente)
    public PerfumariaResponse findById(Long id) {
        Optional<Perfumaria> perfumaria = perfumariaRepository.findById(id);
        return perfumaria.map(perfumariaMapper::perfumariaToResponse).orElse(null);
    }

    // Atualiza os dados de uma perfumaria existente
    public PerfumariaResponse update(PerfumariaRequest perfumariaRequest, Long id) {
        Optional<Perfumaria> optional = perfumariaRepository.findById(id);

        if (optional.isPresent()) {
            Perfumaria existente = optional.get();
            existente.setNome(perfumariaRequest.nome());
            existente.setLocalizacao(perfumariaRequest.localizacao());

            Perfumaria atualizado = perfumariaRepository.save(existente);
            return perfumariaMapper.perfumariaToResponse(atualizado);
        }

        return null; // Poderia lançar uma exceção aqui pra padronizar
    }

    // Deleta uma perfumaria pelo ID, retornando true se deletou com sucesso
    public boolean delete(Long id) {
        Optional<Perfumaria> perfumaria = perfumariaRepository.findById(id);
        if (perfumaria.isPresent()) {
            perfumariaRepository.delete(perfumaria.get());
            return true;
        }
        System.out.println("Não é possível deletar uma Perfumaria que possui produtos");
        return false;
    }
}
