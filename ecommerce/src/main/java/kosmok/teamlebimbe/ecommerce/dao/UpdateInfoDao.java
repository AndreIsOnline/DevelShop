package kosmok.teamlebimbe.ecommerce.dao;

import it.pasqualecavallo.studentsmaterial.authorization_framework.utils.BCryptPasswordEncoder;
import kosmok.teamlebimbe.ecommerce.controller.dto.UpdateCustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UpdateInfoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public boolean UpdateCustomerInfo(UpdateCustomerDto payload) {
        try {
            String password = bCryptPasswordEncoder.encode(payload.getPassword());
            jdbcTemplate.update("UPDATE registration_customer SET user_name = ? WHERE user_email = ?",
                    payload.getUsername(), payload.getEmail());
            jdbcTemplate.update("UPDATE registration_customer SET password = ? WHERE user_email = ?",
                    password, payload.getEmail());
            return true;
        } catch (DataAccessException e) {
            return false;
        }

    }

    public Long getIdByEmail(String email) {
        Long id = jdbcTemplate.queryForObject("SELECT id FROM registration_customer WHERE " +
                "user_email = ?", Long.class, email);

        return  id;
    }

}