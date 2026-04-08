package com.laboratorio.gerador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordController {

    private final PasswordService passwordService;

    // Injeção de Dependência via Construtor
    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @GetMapping("/api/senha")
    public String obterSenha(
            @RequestParam(defaultValue = "10") int tamanho,
            @RequestParam(required = false) String texto) {

    int total = tamanho + ((texto != null) ? texto.length() : 0);

    // Se algo estiver errado, nós "lançamos" o erro. 
    // O programa para aqui e salta direto para o GerenciadorErros.
    if (tamanho <= 0) throw new IllegalArgumentException("O tamanho deve ser maior que zero!");
    if (total > 100)  throw new IllegalArgumentException("O tamanho total não pode exceder 100 caracteres!");

    // O único return: O caminho de sucesso
    return passwordService.gerar(tamanho, texto);
    }
}