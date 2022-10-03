package kosmok.teamlebimbe.ecommerce.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShoppingCartDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<Long> getShoppingCartItemsList(Long id) {
        try {
            return jdbcTemplate.queryForList("SELECT item_item_id FROM shopping_kart WHERE " +
                    "registration_customer_id = ?", Long.class, id );

        } catch (Exception e) {

        }
        // ritorna una lista di item_id presenti nello shopping cart associati all'id di un customer
        return null;
    }

    public Integer getItemQuantityByItemIdAndCustomerId(Long itemId, Long customerId) {
        Integer quantity = jdbcTemplate.queryForObject("SELECT quantity FROM shopping_kart WHERE " +
                "item_item_id = ? AND registration_customer_id = ?", Integer.class, itemId, customerId);

        return  quantity;
    }

    public int updateItemQuantity(int quantity, Long itemId) {
        return jdbcTemplate.update("UPDATE shopping_kart SET quantity=? where item_item_id=?", quantity, itemId);
    }

    public List<String> getStore(Long id) {
        try {
            return jdbcTemplate.queryForList("SELECT name FROM item WHERE " +
                    "seller_id_seller_id = ?", String.class, id );

        } catch (Exception e) {

        }
        return null;
    }


}
