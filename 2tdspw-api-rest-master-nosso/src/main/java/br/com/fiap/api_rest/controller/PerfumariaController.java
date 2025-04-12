package br.com.fiap.api_rest.controller;

import br.com.fiap.api_rest.dto.PerfumariaRequest;
import br.com.fiap.api_rest.dto.PerfumariaResponse;
import br.com.fiap.api_rest.dto.ProdutoResponse;
import br.com.fiap.api_rest.mapper.ProdutoMapper;
import br.com.fiap.api_rest.model.Categoria;
import br.com.fiap.api_rest.model.Produto;
import br.com.fiap.api_rest.repository.ProdutoRepository;
import br.com.fiap.api_rest.service.PerfumariaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/perfumarias")
@Tag(name = "api-perfumarias") // Define um grupo no Swagger
public class PerfumariaController {

    @Autowired
    private PerfumariaService perfumariaService;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoMapper produtoMapper;

    // Construtor com injeção de dependência explícita pro ProdutoRepository e ProdutoMapper
    @Autowired
    public PerfumariaController(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    // Criação de uma nova perfumaria
    @PostMapping
    @Operation(summary = "Cria uma nova perfumaria")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Perfumaria criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos")
    })
    public ResponseEntity<PerfumariaResponse> createPerfumaria(@Valid @RequestBody PerfumariaRequest perfumaria) {
        return new ResponseEntity<>(perfumariaService.save(perfumaria), HttpStatus.CREATED);
    }

    @Operation(summary = "Lista todas as Perfumarias")
    @GetMapping
    public ResponseEntity<List<PerfumariaResponse>> getAllProdutos() {
        return ResponseEntity.ok(perfumariaService.findAll());
    }

    // Buscar perfumaria por ID
    @GetMapping("/{id}")
    @Operation(summary = "Retorna uma perfumaria por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Não encontrada")
    })
    public ResponseEntity<PerfumariaResponse> listarPorId(@PathVariable Long id) {
        PerfumariaResponse perfumaria = perfumariaService.findById(id);
        return perfumaria != null
                ? new ResponseEntity<>(perfumaria, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Listar todos os produtos de uma perfumaria específica
    @GetMapping("/{id}/produtos")
    public ResponseEntity<List<ProdutoResponse>> listarProdutosDaPerfumaria(@PathVariable Long id) {
        List<Produto> produtos = produtoRepository.findByPerfumariaId(id);
        return ResponseEntity.ok(produtoMapper.toResponseList(produtos));
    }

    // Listar produtos de uma perfumaria por categoria (enum Categoria no path)
    @GetMapping("/{id}/produtos/categoria/{categoria}")
    public ResponseEntity<List<ProdutoResponse>> listarPorCategoriaDaPerfumaria(
            @PathVariable Long id,
            @PathVariable Categoria categoria) {
        List<Produto> produtos = produtoRepository.findByPerfumariaIdAndCategoria(id, categoria);
        return ResponseEntity.ok(produtoMapper.produtoToResponseList(produtos));
    }

    // Buscar produto específico dentro de uma perfumaria
    @GetMapping("/{id}/produtos/{idProduto}")
    public ResponseEntity<ProdutoResponse> buscarProdutoPorIdDaPerfumaria(
            @PathVariable Long id,
            @PathVariable Long idProduto) {
        Optional<Produto> produto = produtoRepository.findByIdAndPerfumariaId(idProduto, id);
        return produto.map(value -> ResponseEntity.ok(produtoMapper.toResponse(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Atualiza uma perfumaria existente
    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma perfumaria existente")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "ID inválido ou não encontrada")
    })
    public ResponseEntity<PerfumariaResponse> updatePerfumaria(
            @PathVariable Long id,
            @RequestBody PerfumariaRequest perfumariaRequest) {
        PerfumariaResponse perfumaria = perfumariaService.update(perfumariaRequest, id);
        return perfumaria != null
                ? new ResponseEntity<>(perfumaria, HttpStatus.CREATED)
                : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    // Deleta perfumaria por ID
    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui um perfumaria por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Excluída com sucesso"),
            @ApiResponse(responseCode = "400", description = "ID inválido ou não encontrada"),
            @ApiResponse(responseCode = "500", description = "Não é possível deletar uma Perfumaria que possui produtos")
    })
    public ResponseEntity<Void> deletePerfumaria(@PathVariable Long id) {
        boolean excluida = perfumariaService.delete(id);
        return excluida
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
