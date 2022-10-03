package kosmok.teamlebimbe.ecommerce.entities;





import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seller_id", nullable = false)
    private Long id;
    @Column(length = 61, nullable = false, unique = true)
    private String storeName;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StoreTypes storeType;
    @Column(length = 61, nullable = false)
    private String address;
    @Column(length = 61, nullable = false, unique = true)
    private String email;
    @Column(length = 61, nullable = false)
    private String city;
    @Column(length = 61, nullable = false)
    private String state;
    @Column(length = 255, nullable = false)
    private String password;
    @Column(nullable = false)
    private Integer sellerRating;
    @Column(length = 11, nullable = false, name = "vat_number")
    private String ivaGame;

    @OneToMany(mappedBy = "sellerId")
    private Set<Seller> sellerId;


    public Set<Seller> getSellerId() {
        return sellerId;
    }

    public void setSellerId(Set<Seller> sellerId) {
        this.sellerId = sellerId;
    }

    public StoreTypes getStoreType() {
        return storeType;
    }

    public void setStoreType(StoreTypes storeType) {
        this.storeType = storeType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSellerRating() {
        return sellerRating;
    }

    public void setSellerRating(Integer sellerRating) {
        this.sellerRating = sellerRating;
    }

    public String getIvaGame() {
        return ivaGame;
    }

    public void setIvaGame(String ivaGame) {
        this.ivaGame = ivaGame;
    }




}
