package com.laboratorio.gerador;

import org.springframework.stereotype.Service;
import java.security.SecureRandom;

@Service
public class PasswordService {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*";
    private final SecureRandom random = new SecureRandom();

    // VERSÃO 1: Recebe apenas o tamanho (Chama a Versão 2 passando texto vazio)
    public String gerar(int tamanho) {
        return gerar(tamanho, ""); 
    }

    // VERSÃO 2: Recebe tamanho e prefixo (A lógica principal mora aqui)
    public String gerar(int tamanho, String prefixo) {
        StringBuilder sb = new StringBuilder();
        
        if (prefixo != null && !prefixo.isEmpty()) {
            sb.append(prefixo);
        }

        for (int i = 0; i < tamanho; i++) {
            int index = random.nextInt(ALPHABET.length());
            sb.append(ALPHABET.charAt(index));
        }
        return sb.toString();
    }
}