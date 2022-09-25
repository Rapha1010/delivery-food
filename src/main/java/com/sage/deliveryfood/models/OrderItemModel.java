package com.sage.deliveryfood.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_ORDER_ITEM")
public class OrderItemModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@NotBlank
	@Column(nullable  = false, length = 80)
	private String description;
	@Column(nullable  = false, length = 30)
	private String category;
	@Column(nullable = false)
	private double price;

	private String imageUrl;
	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime creationDateTime;
	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime updateDateTime;
	
	public OrderItemModel(String description, String category, double price,String imageUrl, LocalDateTime creationDateTime, LocalDateTime updateDateTime) {
		this.description = description;
		this.category = category;
		this.price = price;
		this.imageUrl = imageUrl;
		this.creationDateTime = creationDateTime;
		this.updateDateTime = updateDateTime;
	}
	
	public OrderItemModel(){}
	
	//@ManyToOne
	//private OrderModel order;
	
}
