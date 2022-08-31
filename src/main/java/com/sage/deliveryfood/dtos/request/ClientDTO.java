package com.sage.deliveryfood.dtos.request;

import java.util.UUID;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClientDTO {
	
	private UUID id;
	@NotBlank(message = "can not be empty")
	private String name;
	@NotBlank(message = "can not be empty")
	@Email(message = "invalid")
	private String email;
	@NotNull(message = "can not be empty")
	private Long telephone;
	
	public ClientDTO() {}

	public ClientDTO( String name, String email, Long telephone) {
		this.name = name;
		this.email = email;
		this.telephone = telephone;
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return name;
	}

	public void setNome(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTelefone() {
		return telephone;
	}

	public void setTelefone(Long telefone) {
		this.telephone = telefone;
	}

}
