package br.com.fiap.api_rest.service;

import br.com.fiap.api_rest.dto.ProdutoResponse;
import br.com.fiap.api_rest.dto.ProdutoResponseDTO;
import br.com.fiap.api_rest.mapper.ProdutoMapper;
import br.com.fiap.api_rest.model.Categoria;
import br.com.fiap.api_rest.model.Produto;
import br.com.fiap.api_rest.model.StatusProduto;
import br.com.fiap.api_rest.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Define que essa classe é um service, responsável pela lógica de negócio relacionada a Produto
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository; // Repositório de acesso ao banco de dados

    private final ProdutoMapper produtoMapper = new ProdutoMapper(); // Mapper para conversões entre entidade e DTO

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Page<ProdutoResponse> findAll(Pageable pageable) {
        //return livroRepository.findAll(pageable).map(livro -> livroToResponse(livro));
        return produtoRepository.findAll(pageable).map(produtoMapper::produtoToResponse);
    }

    // Retorna todos os produtos paginados no formato ProdutoResponseDTO
    public Page<ProdutoResponseDTO> findAllDTO(Pageable pageable){
        return produtoRepository.findAll(pageable)
                .map(produto -> produtoMapper.produtoToResponseDTO(produto));
    }

    // Salva um novo produto no banco e retorna a resposta mapeada
    public ProdutoResponse save(Produto produto) {
        return produtoMapper.produtoToResponse(
                produtoRepository.save(produto)
        );
    }

    // Busca produto por ID e retorna ProdutoResponse (pode retornar null se não achar)
    public ProdutoResponse findById(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.map(produtoMapper::produtoToResponse).orElse(null);
    }

    // Busca produto por ID e retorna a entidade Produto diretamente (usado internamente)
    public Produto findProdutoById(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElse(null);
    }

    // Busca todos os produtos que pertencem a uma determinada categoria
    public List<ProdutoResponse> findByCategoria(Categoria categoria) {
        List<Produto> produtos = produtoRepository.findByCategoria(categoria);
        return produtos.stream()
                .map(produtoMapper::produtoToResponse)
                .toList();
    }

    // Deleta um produto pelo ID se ele existir no banco, e retorna true se foi deletado com sucesso
    public boolean deleteById(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            produtoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}