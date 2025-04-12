package br.com.fiap.api_rest.dto;

import br.com.fiap.api_rest.model.Categoria;
import br.com.fiap.api_rest.model.StatusProduto;
import jakarta.validation.constraints.*;

// Classe DTO para representar os dados de entrada (requisição) ao criar ou atualizar um Produto
public class ProdutoRequest {

    // Nome do produto - obrigatório e com limite de caracteres
    @NotBlank(message = "O produdo não pode ser nulo ou vazio")
    @Size(min = 3, max = 254, message = "O produto deve ter entre 3 e 254 caracteres")
    private String nome;

    // Local onde o produto está armazenado - obrigatório
    @NotNull(message = "O local de armazenamento não pode ser nulo ou vazio")
    private String localArmazenado;

    // Preço do produto - deve estar entre 1 e 3000
    @Min(value = 1, message = "O preço deve ser no mínimo 1")
    @Max(value = 3000, message = "O preço deve ser no máximo 3000")
    private double preco;

    // Descrição do produto - obrigatória
    @NotNull(message = "A descrição é obrigatória")
    private String descricao;

    // Marca do produto - obrigatória
    @NotNull(message = "A marca não pode ser nula")
    private String marca;

    // Status do produto (DISPONIVEL ou NAO_DISPONIVEL)
    private StatusProduto status;

    // Quantidade em estoque - máximo de 99 unidades
    @Max(value = 99, message = "A quantidade deve ser no máximo 99")
    private int quantidade;

    // Categoria do produto (ex.: PERFUME, BASE, SHAMPOO) - obrigatória
    @NotNull(message = "A categoria é obrigatória")
    private Categoria categoria;

    // ID da perfumaria relacionada ao produto - obrigatório
    @NotNull(message = "O id da perfumaria é obrigatório")
    private Long perfumaria;

    // Getters e Setters padrão abaixo

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public Long getPerfumaria() { return perfumaria; }

    public void setPerfumaria(Long perfumaria) { this.perfumaria = perfumaria; }

    public Categoria getCategoria() { return categoria; }

    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public int getQuantidade() { return quantidade; }

    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public StatusProduto getStatus() { return status; }

    public void setStatus(StatusProduto status) { this.status = status; }

    public String getMarca() { return marca; }

    public void setMarca(String marca) { this.marca = marca; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public double getPreco() { return preco; }

    public void setPreco(double preco) { this.preco = preco; }

    public String getLocalArmazenado() { return localArmazenado; }

    public void setLocalArmazenado(String localArmazenado) { this.localArmazenado = localArmazenado; }
}
