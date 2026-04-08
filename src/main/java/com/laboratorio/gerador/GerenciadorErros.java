package com.laboratorio.gerador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GerenciadorErros {

    // Este método captura qualquer IllegalArgumentException lançada no sistema
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> tratarErroValidacao(IllegalArgumentException ex) {
        // Retornamos status 400 (Bad Request) e a mensagem que escrevemos lá no Controller
        return ResponseEntity.badRequest().body("VALIDAÇÃO: " + ex.getMessage());
    }

    // Mantemos aquele que criamos para o erro de digitar "ABC" no lugar de número
    @ExceptionHandler(org.springframework.web.method.annotation.MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> tratarErroDeTipo() {
        return ResponseEntity.badRequest().body("ERRO: Utilize apenas números inteiros para o tamanho.");
    }
}