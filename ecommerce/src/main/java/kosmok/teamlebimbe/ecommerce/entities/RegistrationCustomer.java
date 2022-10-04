package kosmok.teamlebimbe.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class RegistrationCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "user_name",nullable = false,length = 61)
    private String username;
    @Column(name = "user_email",nullable = false,length = 61,unique = true)
    private String email;
    @Column(nullable = false,length = 255)
    private String password;
   /* @Column(length = 61, nullable = false)
    private String state;
    @Column(length = 61, nullable = false)
    private String city;
    @Column(length = 61, nullable = false)
    private String address;
    @Column(length = 61, nullable = false)
    private String firstName;
    @Column(length = 61, nullable = false)
    private String lastName; */
    private Integer emailconfermata;

    @JsonIgnore
    @OneToMany (mappedBy = "registrationCustomer")
    private Set<ShoppingKart> customerItem ;

    public Set<ShoppingKart> getCustomerItem() {
        return customerItem;
    }


    public void setCustomerItem(Set<ShoppingKart> customerItem) {
        this.customerItem = customerItem;
    }

  /*  public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    } */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEmailconfermata() {
        return emailconfermata;
    }

    public void setEmailconfermata(Integer emailconfermata) {
        this.emailconfermata = emailconfermata;
    }
}
