package com.sage.deliveryfood.dtos.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
@Data
public class OrderItenDTO {
	
	@NotBlank
	private String description;
	@NotNull
	private double price;
	@NotBlank
	private String imageUrl;

}
