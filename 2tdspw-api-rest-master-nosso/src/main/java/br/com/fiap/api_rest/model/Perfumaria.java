package br.com.fiap.api_rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

// Classe que representa a entidade Perfumaria no banco de dados
@Entity
public class Perfumaria {

    // Identificador único da perfumaria (gerado automaticamente pelo banco)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome da perfumaria (não pode ser nulo)
    @NotNull
    private String nome;

    // Localização da perfumaria (não pode ser nulo)
    @NotNull
    private String localizacao;

    // -------------------- GETTERS E SETTERS --------------------

    // Retorna o ID da perfumaria
    public Long getId() {
        return id;
    }

    // Define o ID da perfumaria
    public void setId(Long id) {
        this.id = id;
    }

    // Retorna o nome da perfumaria
    public String getNome() {
        return nome;
    }

    // Define o nome da perfumaria
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Retorna a localização da perfumaria
    public String getLocalizacao() {
        return localizacao;
    }

    // Define a localização da perfumaria
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}