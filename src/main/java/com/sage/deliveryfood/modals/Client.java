package com.sage.deliveryfood.modals;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", columnDefinition = "BINARY(16)")
	private UUID id;
	
	private Long number;
	private String name;
	private String email;
	private Long phoneNumber;
	
	public Client() {}

	public Client(String name, String email, Long phoneNumber) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
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
		return phoneNumber;
	}

	public void setTelefone(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


}
