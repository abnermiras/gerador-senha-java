package com.laboratorio.gerador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GeradorApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeradorApplication.class, args);
	}

    // Este bloco vai rodar assim que o programa ligar, como um Job de teste
    @Bean
    public CommandLineRunner executar(PasswordService service) {
        return args -> {
            String senha = service.gerar(15);
            String texto = service.gerar(15, "PREFIXO-");
            System.out.println("\n*********************************");
            System.out.println("Senha simples: " + senha);
            System.out.println("Senha com prefixo: " + texto);
            System.out.println("*********************************\n");
            System.out.println("\n*********************************");
            System.out.println("Senha simples: " + service.gerar(10));
            System.out.println("Senha com prefixo: " + service.gerar(10, "TESTE-"));
            System.out.println("*********************************\n");
        };
    }
}