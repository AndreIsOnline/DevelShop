package kosmok.teamlebimbe.ecommerce.dao;

import kosmok.teamlebimbe.ecommerce.model.OrderItemsModel;
import kosmok.teamlebimbe.ecommerce.model.OrderModel;
import kosmok.teamlebimbe.ecommerce.model.ShoppingCartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public List<OrderModel> getOrdersByCustomerId(Long customerId) {

        List<OrderModel> currentOrderList = new ArrayList<>();

        try {
            currentOrderList = jdbcTemplate.query("SELECT * FROM orders WHERE customer_id = ?",
                    new RowMapper<OrderModel>() {
                @Override
                public OrderModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                    OrderModel om = new OrderModel();
                    om.setOrderId(rs.getLong("order_id"));
                    om.setCustomerId(rs.getLong("customer_id"));
                    om.setDate(rs.getLong("order_date"));
                    return om;
                }
            }, customerId);
            return currentOrderList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<OrderItemsModel> getOrderItemsByOrderId(Long orderId) {

        List<OrderItemsModel> currentItemsList;

        try {
            currentItemsList = jdbcTemplate.query("SELECT * FROM order_items WHERE order_id_order_id = ?",
                    new RowMapper<OrderItemsModel>() {
                        @Override
                        public OrderItemsModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                            OrderItemsModel oim = new OrderItemsModel();
                            oim.setItemId(rs.getLong("item_id"));
                            oim.setQuantity(rs.getInt("quantity"));
                            oim.setOrderId(rs.getLong("order_id_order_id"));
                            return oim;
                        }
                    }, orderId);
            return currentItemsList;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean doesOrderExistById(Long orderId) {

        try {
            jdbcTemplate.queryForObject("SELECT 1 FROM orders WHERE order_id = ?", Integer.class, orderId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
