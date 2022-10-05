package kosmok.teamlebimbe.ecommerce.entities;

import javax.persistence.*;
import java.util.Date;
@Table
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id", nullable = false)
    private Long id;

    @Column(nullable = false,name = "user_name")
    private String username;
    @Column(nullable = false,name = "user_password")
    private String password;
    @Column(length = 61, nullable = false, unique = true)
    private String email;
    @Column(length = 61)
    private String city;
    public Admin(){}

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
