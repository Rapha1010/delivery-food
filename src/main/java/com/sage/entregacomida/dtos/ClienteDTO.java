package com.sage.entregacomida.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteDTO {
	
	private Long id;
	@NotBlank(message = "nome nao pode ser vazio")
	private String nome;
	@Email(message = "email invalido")
	private String email;
	@NotNull(message = "telefone nao pode ser vazio")
	private Long telefone;
	
	public ClienteDTO() {}

	public ClienteDTO( String nome, String email, Long telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

}
