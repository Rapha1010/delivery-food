package com.sage.deliveryfood.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "TB_CLIENT")
public class ClientModel extends RepresentationModel<ClientModel> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "id", columnDefinition = "BINARY(16)")
	private UUID id;
	@Column(nullable = false, length = 10)
	private Long number;
	@Column(nullable = false, length = 40)
	private String name;
	@Column(nullable = false, length = 40)
	@Email
	private String email;
	@Column(nullable = false, length = 40)
	private Long phoneNumber;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<OrderModel> orders;

	public ClientModel(String name, @Email String email, Long phoneNumber) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public ClientModel() {}
	
	
}
