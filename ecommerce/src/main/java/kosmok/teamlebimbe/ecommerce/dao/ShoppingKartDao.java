package kosmok.teamlebimbe.ecommerce.dao;

import it.pasqualecavallo.studentsmaterial.authorization_framework.utils.BCryptPasswordEncoder;
import kosmok.teamlebimbe.ecommerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShoppingKartDao {

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


}
