package com.servico.rest.api;

import java.security.spec.PSSParameterSpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.servico.rest.api.utils.PasswordUtils;

@SpringBootApplication
public class MeuPrimeiroProjetoApplication {

	@Value("${paginacao.qtd}")
	int paginacaoQtd;

	public static void main(String[] args) {
		SpringApplication.run(MeuPrimeiroProjetoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args ->{System.out.println("#### O valor da paginação é "+paginacaoQtd);
			String senhaEncoded = PasswordUtils.geraBcrypt("123456");
			System.out.println("Snhea encoded = "+ senhaEncoded);
			
		
			System.out.println(PasswordUtils.validarBCrypt("123456", senhaEncoded));
		};
	}

	private void test(int i) {

	}

	public int getPaginacaoQtd() {
		return paginacaoQtd;
	}

	public void setPaginacaoQtd(int paginacaoQtd) {
		this.paginacaoQtd = paginacaoQtd;
	}


}
