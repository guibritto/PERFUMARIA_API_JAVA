package br.com.fiap.api_rest.mapper;

import br.com.fiap.api_rest.dto.ProdutoRequest;
import br.com.fiap.api_rest.dto.ProdutoResponse;
import br.com.fiap.api_rest.dto.ProdutoResponseDTO;
import br.com.fiap.api_rest.model.Produto;
import br.com.fiap.api_rest.model.StatusProduto;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

import java.util.List;

@Component
public class ProdutoMapper {

    // Converte a entidade Produto para o DTO ProdutoResponse
    public ProdutoResponse toResponse(Produto produto) {
        // Define o status com base na quantidade disponível
        StatusProduto status = produto.getQuantidade() > 0
                ? StatusProduto.DISPONIVEL
                : StatusProduto.NAO_DISPONIVEL;

        // Cria e retorna o DTO com os dados necessários
        return new ProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getCategoria(),
                produto.getMarca(),
                produto.getDescricao(),
                produto.getQuantidade(),
                status,
                produto.getPerfumaria()
        );
    }

    // Converte uma lista de Produtos para uma lista de ProdutoResponse
    public List<ProdutoResponse> toResponseList(List<Produto> produtos) {
        return produtos.stream()
                .map(this::toResponse) // Aplica o método de conversão individual
                .collect(Collectors.toList());
    }

    // Converte um ProdutoRequest (DTO de entrada) para a entidade Produto
    public Produto requestToProduto(ProdutoRequest produtoRequest) {
        Produto produto = new Produto();
        produto.setNome(produtoRequest.getNome());
        produto.setMarca(produtoRequest.getMarca());
        produto.setDescricao(produtoRequest.getDescricao());
        produto.setPreco(produtoRequest.getPreco());
        produto.setQuantidade(produtoRequest.getQuantidade());
        produto.setCategoria(produtoRequest.getCategoria());
        return produto;
    }

    // Método redundante, reutiliza o toResponse() para manter consistência
    public ProdutoResponse produtoToResponse(Produto produto) {
        return toResponse(produto);
    }

    // Converte uma lista de entidades Produto para uma lista de ProdutoResponse
    public List<ProdutoResponse> produtoToResponseList(List<Produto> produtos) {
        return produtos.stream()
                .map(this::produtoToResponse) // Mesma lógica do método acima
                .toList(); // Alternativa moderna ao Collectors.toList()
    }

    // Converte entidade Produto para o ProdutoResponseDTO (formato compacto)
    public ProdutoResponseDTO produtoToResponseDTO(Produto produto) {
        return new ProdutoResponseDTO(
                produto.getId(),
                produto.getNome(),
                produto.getCategoria(),
                produto.getMarca(),
                produto.getDescricao(),
                produto.getStatus(), // Usa o status já presente na entidade
                produto.getPerfumaria()
        );
    }
}
