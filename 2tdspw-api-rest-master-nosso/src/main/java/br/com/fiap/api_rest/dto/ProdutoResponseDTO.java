package br.com.fiap.api_rest.dto;

import br.com.fiap.api_rest.model.Categoria;
import br.com.fiap.api_rest.model.Perfumaria;
import br.com.fiap.api_rest.model.StatusProduto;

public record ProdutoResponseDTO(
        Long id, // ID do produto
        String nome, // Nome do produto
        Categoria categoria, // Categoria do produto
        String marca, // Marca do produto
        String descricao, // Descrição do produto
        StatusProduto statusProduto, // Status: DISPONIVEL ou NAO_DISPONIVEL
        Perfumaria perfumaria // Objeto da perfumaria associada
) {
}
