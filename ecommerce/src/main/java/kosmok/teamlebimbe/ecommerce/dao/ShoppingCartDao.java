package kosmok.teamlebimbe.ecommerce.dao;

import kosmok.teamlebimbe.ecommerce.repository.IRegistrationCustomerRepository;
import kosmok.teamlebimbe.ecommerce.repository.IShoppingKart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class ShoppingCartDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IShoppingKart iShoppingKart;

    @Autowired
    private IRegistrationCustomerRepository iRegistrationCustomerRepository;





}
