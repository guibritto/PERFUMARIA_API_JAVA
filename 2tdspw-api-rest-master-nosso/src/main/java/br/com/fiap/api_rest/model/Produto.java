package br.com.fiap.api_rest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

// Classe que representa a entidade Produto no banco de dados
@Entity
public class Produto {

    // Identificador único do produto (gerado automaticamente)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome do produto (obrigatório e com pelo menos 1 caractere)
    @NotBlank
    @Size(min = 1)
    private String nome;

    // Local onde o produto está armazenado (pode ser nulo)
    private String localArmazenado;

    // Preço do produto (obrigatório)
    @NotNull
    private double preco;

    // Descrição do produto (obrigatório) - Ex: aroma, voltagem, tipo de cabelo etc.
    @NotNull
    private String descricao;

    // Marca do produto (obrigatório) - Ex: Natura, Dior, etc.
    @NotNull
    private String marca;

    // Status do produto (DISPONIVEL ou NAO_DISPONIVEL)
    @Enumerated(EnumType.STRING)
    private StatusProduto status;

    // Quantidade disponível (mínimo 0)
    @Min(0)
    private int quantidade;

    // Categoria do produto (obrigatória) - ex: PERFUME, SHAMPOO, BATOM, etc.
    @NotNull
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    // Perfumaria à qual o produto pertence (relacionamento obrigatório)
    @ManyToOne
    @JoinColumn(name = "perfumaria_id", nullable = false)
    private Perfumaria perfumaria;

    // -------------------- GETTERS E SETTERS --------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalArmazenado() {
        return localArmazenado;
    }

    public void setLocalArmazenado(String localArmazenado) {
        this.localArmazenado = localArmazenado;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public StatusProduto getStatus() {
        return status;
    }

    public void setStatus(StatusProduto status) {
        this.status = status;
    }

    public int getQuantidade() {
        return quantidade;
    }

    // Ao definir a quantidade, também altera o status do produto automaticamente
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        if (quantidade == 0) {
            this.status = StatusProduto.NAO_DISPONIVEL;
        } else {
            this.status = StatusProduto.DISPONIVEL;
        }
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Perfumaria getPerfumaria() {
        return perfumaria;
    }

    public void setPerfumaria(Perfumaria perfumaria) {
        this.perfumaria = perfumaria;
    }
}