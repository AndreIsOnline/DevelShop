package kosmok.teamlebimbe.ecommerce.entities;

import javax.persistence.*;

@Entity
@Table
public class ShoppingKart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Integer quantity;

    private Long dateAdd=System.currentTimeMillis();

    @ManyToOne
    private RegistrationCustomer registrationCustomer;

    @ManyToOne
    private Item item;


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getDateAdd() {
        return dateAdd;
    }



    public void setItemId(Item item,long id) {
        item.setId(id);
    }

    public void setDateAdd(Long dateAdd) {
        this.dateAdd = dateAdd;
    }

    public RegistrationCustomer getRegistration() {
        return registrationCustomer;
    }

    public void setRegistration(RegistrationCustomer registrationCustomer) {
        this.registrationCustomer = registrationCustomer;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
