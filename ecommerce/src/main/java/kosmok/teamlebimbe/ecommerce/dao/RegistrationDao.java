package kosmok.teamlebimbe.ecommerce.dao;

import it.pasqualecavallo.studentsmaterial.authorization_framework.utils.BCryptPasswordEncoder;
import kosmok.teamlebimbe.ecommerce.controller.dto.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;




@Repository
public class RegistrationDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public boolean checkUserExistByEmail(String email) {
        try {
            jdbcTemplate.queryForObject("SELECT 1 FROM registration r WHERE r.email=?", Integer.class, email);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }
    public boolean checkUserExistByUsername(String username) {
        try {
            jdbcTemplate.queryForObject("SELECT 1 FROM registration r WHERE r.username=?", Integer.class, username);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }

    public boolean save(RegistrationRequest payload) {
        String password = bCryptPasswordEncoder.encode(payload.getPassword());
        int changed =jdbcTemplate.update("INSERT INTO registration_customer (user_email, user_name, password,emailconfermata) VALUES(?,?,?,?)",
                payload.getEmail(), payload.getUsername(),password,0);
        return changed == 1;
    }

}
