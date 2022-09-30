package kosmok.teamlebimbe.ecommerce.controller.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PostItemDto {

	@NotEmpty
	private String name;

	@NotEmpty
	private String description;

	@NotNull
	private Integer quantityInStock;

	@NotNull
	private Integer unitPrice;



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(Integer quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

}
