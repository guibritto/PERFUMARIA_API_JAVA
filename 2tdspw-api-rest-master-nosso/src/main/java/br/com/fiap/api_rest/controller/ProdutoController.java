package br.com.fiap.api_rest.controller;

import br.com.fiap.api_rest.dto.PerfumariaResponse;
import br.com.fiap.api_rest.dto.ProdutoRequest;
import br.com.fiap.api_rest.dto.ProdutoResponse;
import br.com.fiap.api_rest.mapper.ProdutoMapper;
import br.com.fiap.api_rest.model.Categoria;
import br.com.fiap.api_rest.model.Perfumaria;
import br.com.fiap.api_rest.model.Produto;
import br.com.fiap.api_rest.service.PerfumariaService;
import br.com.fiap.api_rest.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produto")
@Tag(name = "api-produtos") // Swagger - define o grupo/tag da API
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoMapper produtoMapper;

    @Autowired
    private PerfumariaService perfumariaService;

    @Operation(summary = "Registrar novo produto")
    @PostMapping
    public ResponseEntity<ProdutoResponse> create(@Valid @RequestBody ProdutoRequest produtoRequest) {
        // Converte o DTO para a entidade
        Produto produto = produtoMapper.requestToProduto(produtoRequest);
        // Associa a perfumaria correta
        produto.setPerfumaria(perfumariaService.findPerfumariaById(produtoRequest.getPerfumaria()));
        // Salva e retorna
        return new ResponseEntity<>(produtoService.save(produto), HttpStatus.CREATED);
    }

    @PostMapping("/lote")
    public ResponseEntity<List<ProdutoResponse>> createMultiplos(@Valid @RequestBody List<ProdutoRequest> produtosRequest) {
        List<ProdutoResponse> responses = new ArrayList<>();
        // Para cada produto, converte, seta perfumaria e salva
        for (ProdutoRequest request : produtosRequest) {
            Produto produto = produtoMapper.requestToProduto(request);
            produto.setPerfumaria(perfumariaService.findPerfumariaById(request.getPerfumaria()));
            ProdutoResponse response = produtoService.save(produto);
            responses.add(response);
        }
        return new ResponseEntity<>(responses, HttpStatus.CREATED);
    }

    // Listagem paginada de produtos
    @GetMapping
    @Operation(summary = "Lista produtos por página")
    public ResponseEntity<Page<ProdutoResponse>> listarProdutos(@RequestParam(defaultValue = "0") Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.by("nome").ascending());
        return new ResponseEntity<>(produtoService.findAll(pageable), HttpStatus.OK);
    }

    @Operation(summary = "Lista todos os produtos por categoria")
    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<ProdutoResponse>> getByCategoria(@PathVariable Categoria categoria) {
        return ResponseEntity.ok(produtoService.findByCategoria(categoria));
    }

    @Operation(summary = "Retorna um produto pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> listarPorId(@PathVariable Long id) {
        ProdutoResponse produtoResponse = produtoService.findById(id);
        if (produtoResponse == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 👍 Retorno sem corpo tá ok
        }
        return new ResponseEntity<>(produtoResponse,HttpStatus.OK);
    }

    @Operation(summary = "Atualiza um produto existente")
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> updateProduto(@PathVariable Long id,
                                                         @RequestBody ProdutoRequest produtoRequest) {
        Produto produto = produtoService.findProdutoById(id);
        if (produto == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        // Atualiza os campos com os novos dados
        Produto produtoConvertido = produtoMapper.requestToProduto(produtoRequest);
        produtoConvertido.setId(produto.getId());
        produtoConvertido.setPerfumaria(perfumariaService.findPerfumariaById(produtoRequest.getPerfumaria()));

        return new ResponseEntity<>(produtoService.save(produtoConvertido), HttpStatus.CREATED);
    }

    @Operation(summary = "Exclui um produto por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        boolean deletado = produtoService.deleteById(id);
        if (!deletado) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

