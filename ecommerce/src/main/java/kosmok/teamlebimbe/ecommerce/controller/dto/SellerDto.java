package kosmok.teamlebimbe.ecommerce.controller.dto;

import kosmok.teamlebimbe.ecommerce.entities.StoreTypes;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class SellerDto {

    private String storeName;

    private StoreTypes storeType;

    private String address;

    private String city;

    private String state;

    private String password;

    private Integer sellerRating;

    private String ivaGame;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public StoreTypes getStoreType() {
        return storeType;
    }

    public void setStoreType(StoreTypes storeType) {
        this.storeType = storeType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
