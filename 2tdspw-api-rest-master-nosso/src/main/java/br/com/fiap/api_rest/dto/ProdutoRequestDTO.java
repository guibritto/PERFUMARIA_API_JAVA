package br.com.fiap.api_rest.dto;

import br.com.fiap.api_rest.model.Categoria;
import jakarta.validation.constraints.*;

public record ProdutoRequestDTO(

        @NotBlank(message = "O nome do produto é obrigatório") // Nome do produto, não pode estar em branco
        @Size(min = 3, max = 254, message = "O nome deve ter entre 3 e 254 caracteres") // Validação de tamanho
        String nome,

        @NotNull(message = "O local de armazenamento não pode ser nulo") // Local onde o produto está armazenado
        String localArmazenado,

        @Min(value = 1, message = "O preço deve ser no mínimo 1") // Preço mínimo
        @Max(value = 3000, message = "O preço deve ser no máximo 3000") // Preço máximo
        double preco,

        @NotNull(message = "A descrição é obrigatória") // Descrição do produto (ex: Amadeirado, 220v, etc.)
        String descricao,

        @NotNull(message = "A marca não pode ser nula") // Marca do produto (ex: Dior, Natura)
        String marca,

        @Max(value = 99, message = "A quantidade deve ser no máximo 99") // Quantidade em estoque (máx. 99)
        int quantidade,

        @NotNull(message = "A categoria é obrigatória") // Categoria do produto (relacionamento com entidade Categoria)
        Categoria categoria,

        @NotNull(message = "O id da perfumaria é obrigatório") // ID da perfumaria associada ao produto
        Long perfumaria

) {}