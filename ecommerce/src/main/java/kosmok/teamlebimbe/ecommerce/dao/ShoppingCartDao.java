package kosmok.teamlebimbe.ecommerce.dao;

import it.pasqualecavallo.studentsmaterial.authorization_framework.filter.AuthenticationContext;
import it.pasqualecavallo.studentsmaterial.authorization_framework.service.UserDetails;
import kosmok.teamlebimbe.ecommerce.model.ShoppingCartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
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
        try {
            Integer quantity = jdbcTemplate.queryForObject("SELECT quantity FROM shopping_kart WHERE " +
                    "item_item_id = ? AND registration_customer_id = ?", Integer.class, itemId, customerId);

            return  quantity;
        } catch (Exception e) {
            return null;
        }

    }
    public int updateItemQuantity(int quantity, Long itemId, Long customerId) {
        return jdbcTemplate.update("UPDATE shopping_kart SET quantity = ? where item_item_id = ? " +
                "AND registration_customer_id = ?", quantity, itemId, customerId);
    }

    public List<String> getStore(Long id) {
        try {
            return jdbcTemplate.queryForList("SELECT name FROM item WHERE " +
                    "seller_id_seller_id = ?", String.class, id );

        } catch (Exception e) {

        }
        return null;
    }

    public boolean checkIfUserHasItemInCart(Long itemId, Long userId) {

        try {
            jdbcTemplate.queryForObject("SELECT 1 FROM shopping_kart WHERE item_item_id = ? " +
                    "AND registration_customer_id = ?", Integer.class, itemId, userId);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }

    public List<ShoppingCartModel> getAllItemsByCustomerId() {
        Long currentUserId = AuthenticationContext.get().getUserId();
        List<ShoppingCartModel> currentUserItemList = new ArrayList<>();

        try {

            currentUserItemList = jdbcTemplate.query("SELECT * FROM shopping_kart WHERE" +
                    " registration_customer_id = ?", new RowMapper<ShoppingCartModel>() {
                @Override
                public ShoppingCartModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                    ShoppingCartModel scm = new ShoppingCartModel();
                    scm.setItemId(rs.getLong("item_item_id"));
                    scm.setQuantity(rs.getInt("quantity"));
                    scm.setCustomerId(rs.getLong("registration_customer_id"));
                    return scm;
                }
            }, currentUserId);
            return currentUserItemList;
        } catch (Exception e) {
            return null;
        }
    }

    public void deleteCartByCustomerId(Long customerId) {
        try {
            jdbcTemplate.update("DELETE FROM shopping_kart WHERE registration_customer_id = ?", customerId);
        } catch (Exception e) {

        }
    }

    public int deleteItemFromCart(Long itemId, Long customerId){
        return jdbcTemplate.update("DELETE FROM shopping_kart " +
                "WHERE registration_customer_id = ? AND item_item_id = ?", customerId, itemId);
    }


}


