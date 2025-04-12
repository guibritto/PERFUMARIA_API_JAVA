package br.com.fiap.api_rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

// Define uma classe global para tratar exceções
@ControllerAdvice
public class ValidationExceptionHandler {

    // Especifica que esse método trata exceções do tipo MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        // Cria um mapa para armazenar os erros (campo -> mensagem)
        Map<String, String> errors = new HashMap<>();

        // Itera sobre todos os erros de validação dos campos
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        // Adiciona o nome do campo e a mensagem de erro no mapa
                        errors.put(error.getField(), error.getDefaultMessage())
                );

        // Retorna os erros com status 400 (BAD_REQUEST)
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
