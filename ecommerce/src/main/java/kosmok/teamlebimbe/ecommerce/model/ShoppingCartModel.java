package kosmok.teamlebimbe.ecommerce.model;

public class ShoppingCartModel {

    private Long itemId;

    private Integer quantity;

    private Long customerId;

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getItemId() {
        return itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Long getCustomerId() {
        return customerId;
    }
}
