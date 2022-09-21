package com.sage.deliveryfood.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sage.deliveryfood.enums.StatusType;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_ORDER_MODEL")
public class OrderModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "id", columnDefinition = "BINARY(16)")
	private UUID id;
	@NotBlank
	@Column(nullable = false, length = 200)
	private String address;
	@NotNull
	@Column(nullable = false)
	private Integer estimatedTimeInMin;
	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime creationDateTime;
	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime updateDateTime;
	@NotNull
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusType status;
	
	@ManyToOne
	private ClientModel client;
	
//	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
//	private Set<OrderItemModel> orderItens;

	public OrderModel(@NotBlank String address, @NotNull Integer estimatedTimeInMin, LocalDateTime creationDateTime, LocalDateTime updateDateTime,
			@NotNull StatusType status, ClientModel client) {
		super();
		this.address = address;
		this.estimatedTimeInMin = estimatedTimeInMin;
		this.creationDateTime = creationDateTime;
		this.updateDateTime = updateDateTime;
		this.status = status;
		this.client = client;
	}
	
	public OrderModel() {}

}
