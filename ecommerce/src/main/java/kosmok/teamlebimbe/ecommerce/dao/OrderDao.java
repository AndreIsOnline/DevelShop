package kosmok.teamlebimbe.ecommerce.dao;

import kosmok.teamlebimbe.ecommerce.model.ShoppingCartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void createNewOrderByCustomerIdAndByCartList(Long customerId, List<ShoppingCartModel> itemsList) {

        Long timeStamp = System.currentTimeMillis();
        jdbcTemplate.update("INSERT INTO orders (order_date, customer_id) values (?, ?)", timeStamp, customerId);

        Long orderId = this.getOrderIdByDateAndCustomer(customerId, timeStamp);


        itemsList.forEach(item -> {
            jdbcTemplate.update("INSERT INTO order_items (item_id, customer_id, order_id_order_id, quantity) " +
                    "values (?, ?, ?, ?)", item.getItemId(), item.getCustomerId(),  orderId, item.getQuantity());
        });


    }


    public Long getOrderIdByDateAndCustomer(Long customerId, Long date) {
        return jdbcTemplate.queryForObject("SELECT order_id FROM orders where customer_id = ? " +
                "AND order_date = ?", Long.class, customerId, date);
    }
}
