package com.servico.rest.api.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {

	/**
	 * Gera hash através do BCrypt
	 */
	public static String geraBcrypt(String senha) {
		if (senha == null) {
			return senha;
		}
		// Método que codifica o hash
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder.encode(senha);
	}
	
	
	/**
	 * Valida a senha com o hash da senha do banco de dados
	 * @param senhaAtual
	 * @param senhaHash
	 * @return boolean
	 */
	public static boolean validarBCrypt(String senhaAtual, String senhaHash) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder.matches(senhaAtual, senhaHash);
	}
	
}
