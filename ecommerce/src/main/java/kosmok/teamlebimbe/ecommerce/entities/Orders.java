package kosmok.teamlebimbe.ecommerce.entities;

import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table

public class Orders {

    //mettere l item id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private Long orderDate=System.currentTimeMillis();

    @Column(nullable = false)
    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Long orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }





}
