package br.com.fiap.api_rest.repository;

import br.com.fiap.api_rest.model.Categoria;
import br.com.fiap.api_rest.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository // Marca essa interface como um repositório, pra injeção de dependência e integração com Spring Data JPA
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    // Busca todos os produtos com a categoria especificada
    List<Produto> findByCategoria(Categoria categoria);

    // Busca todos os produtos associados a uma determinada perfumaria pelo ID
    List<Produto> findByPerfumariaId(Long Id);

    // Busca todos os produtos de uma perfumaria específica e de uma categoria específica
    List<Produto> findByPerfumariaIdAndCategoria(Long perfumariaId, Categoria categoria);

    // Busca um produto específico dentro de uma perfumaria específica
    Optional<Produto> findByIdAndPerfumariaId(Long produtoId, Long perfumariaId);
}

