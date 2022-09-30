package kosmok.teamlebimbe.ecommerce.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import it.pasqualecavallo.studentsmaterial.authorization_framework.utils.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import it.pasqualecavallo.studentsmaterial.authorization_framework.dao.UserDao;
import it.pasqualecavallo.studentsmaterial.authorization_framework.service.UserDetails;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserDetails getUserByUsername(String username) {
        String query="Select * FROM registration_customer where user_name =?";
        List<UserDetails> userDetails=jdbcTemplate.query(query, new RowMapper<UserDetails>() {
            @Override
            public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserDetails userDetails1=new UserDetails();
                userDetails1.setUsername(rs.getString("user_name"));
                userDetails1.setPassword(rs.getString("password"));
                userDetails1.setRoles(Arrays.asList("customer"));
                userDetails1.setUserId(rs.getLong("id"));
                return userDetails1;
            }
        },username);
        if(userDetails.isEmpty()){
            String querySeller="Select * FROM seller where store_name =?";
            userDetails=jdbcTemplate.query(querySeller, new RowMapper<UserDetails>() {
                @Override
                public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                    UserDetails userDetails1=new UserDetails();
                    userDetails1.setUsername(rs.getString("store_name"));
                    userDetails1.setPassword(rs.getString("password"));
                    userDetails1.setRoles(Arrays.asList("seller"));
                    userDetails1.setUserId(rs.getLong("seller_id"));
                    return userDetails1;
                }
            },username);
        }
        if(userDetails.isEmpty()){
            String queryAdmin="Select * FROM admin where user_name =?";
            userDetails=jdbcTemplate.query(queryAdmin, new RowMapper<UserDetails>() {
                @Override
                public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                    UserDetails userDetails1=new UserDetails();
                    userDetails1.setUsername(rs.getString("user_name"));
                    userDetails1.setPassword(rs.getString("user_password"));
                    userDetails1.setRoles(Arrays.asList("admin"));
                    userDetails1.setUserId(rs.getLong("admin_id"));
                    return userDetails1;
                }
            },username);

        }

        return userDetails.isEmpty()?null:userDetails.get(0);
    }



}
