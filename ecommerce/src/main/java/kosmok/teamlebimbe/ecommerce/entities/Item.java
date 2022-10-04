package kosmok.teamlebimbe.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", nullable = false)
    private Long id;


    @Column(length = 61, nullable = false)
    private String name;
    @Column(length = 255, nullable = true)
    private String description;
    @Column
    private Integer quantityInStock;
    @Column(nullable = false)
    private Integer unitPrice;
    @Column(nullable = false)
    private Long timeOfInsertion=System.currentTimeMillis();

    @OneToMany(mappedBy = "item")
    private Set<ShoppingKart> orderItems;

    @JsonIgnore
    @ManyToOne
    private Seller sellerId;


    public Item() {}

    public Set<ShoppingKart> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<ShoppingKart> orderItems) {
        this.orderItems = orderItems;
    }

    public Seller getSellerId() {
        return sellerId;
    }

    public void setSellerId(Seller sellerId) {
        this.sellerId = sellerId;
    }


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

}
