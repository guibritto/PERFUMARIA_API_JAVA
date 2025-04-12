package br.com.fiap.api_rest.dto;

import br.com.fiap.api_rest.model.Categoria;
import br.com.fiap.api_rest.model.Perfumaria;
import br.com.fiap.api_rest.model.Produto;
import br.com.fiap.api_rest.model.StatusProduto;

// Classe DTO para retorno dos dados do Produto (resposta da API)
public class ProdutoResponse {

    private Long id; // ID do produto
    private String nome; // Nome do produto
    private Categoria categoria; // Categoria do produto (ex.: PERFUME, CREME)
    private String marca; // Marca do produto
    private String descricao; // Descrição do produto
    private int quantidade; // Quantidade disponível em estoque
    private StatusProduto status; // DISPONIVEL ou NAO_DISPONIVEL
    private String nomePerfumaria; // Nome da perfumaria associada ao produto
    private String localPerfumaria; // Localização da perfumaria

    // Construtor que recebe os campos e um objeto Perfumaria para preencher os dados relacionados
    public ProdutoResponse(
            Long id,
            String nome,
            Categoria categoria,
            String marca,
            String descricao,
            int quantidade,
            StatusProduto status,
            Perfumaria perfumaria
    ) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.marca = marca;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.status = status;
        this.nomePerfumaria = perfumaria.getNome(); // Puxa o nome da perfumaria
        this.localPerfumaria = perfumaria.getLocalizacao(); // Puxa a localização da perfumaria
    }

    // Getters e Setters padrão abaixo

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public Categoria getCategoria() { return categoria; }

    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public String getMarca() { return marca; }

    public void setMarca(String marca) { this.marca = marca; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public int getQuantidade() { return quantidade; }

    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public StatusProduto getStatus() { return status; }

    public void setStatus(StatusProduto status) { this.status = status; }

    public String getNomePerfumaria() { return nomePerfumaria; }

    public void setNomePerfumaria(String nomePerfumaria) { this.nomePerfumaria = nomePerfumaria; }

    public String getLocalPerfumaria() { return localPerfumaria; }

    public void setLocalPerfumaria(String localPerfumaria) { this.localPerfumaria = localPerfumaria; }
}
