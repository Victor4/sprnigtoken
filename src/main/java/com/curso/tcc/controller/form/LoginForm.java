package com.curso.tcc.controller.form;

import com.curso.tcc.model.Usuario;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginForm {

	private String nome;
	private String email;
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(email, senha);
	}

	public Usuario converterToUsuario(){
		if(nome.isEmpty() || email.isEmpty() || senha.isEmpty()){
			return null;
		}else {
			return new Usuario(
					this.nome,
					this.email,
					this.senha,
					"0");
		}
	}

}
