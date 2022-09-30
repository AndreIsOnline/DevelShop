package kosmok.teamlebimbe.ecommerce.model;

import kosmok.teamlebimbe.ecommerce.entities.Seller;
import kosmok.teamlebimbe.ecommerce.entities.ShoppingKart;

import javax.persistence.*;
import java.util.Set;

public class ItemModel {

    private Long id;
    private String name;
    private String description;

    private Integer quantityInStock;
    private Integer unitPrice;
    private Long timeOfInsertion=System.currentTimeMillis();

    private Long sellerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getTimeOfInsertion() {
        return timeOfInsertion;
    }

    public void setTimeOfInsertion(Long timeOfInsertion) {
        this.timeOfInsertion = timeOfInsertion;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
}
