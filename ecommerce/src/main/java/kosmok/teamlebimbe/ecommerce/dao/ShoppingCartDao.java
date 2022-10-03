package kosmok.teamlebimbe.ecommerce.dao;

import kosmok.teamlebimbe.ecommerce.repository.IRegistrationCustomerRepository;
import kosmok.teamlebimbe.ecommerce.repository.IShoppingKart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class ShoppingCartDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<String> getStore(Long id) {
        try {
            return jdbcTemplate.queryForList("SELECT name FROM item WHERE " +
                    "seller_id_seller_id = ?", String.class, id );

        } catch (Exception e) {

        }
        return null;
    }

}
