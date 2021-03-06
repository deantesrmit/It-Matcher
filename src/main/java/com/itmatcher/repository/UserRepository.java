package com.itmatcher.repository;

import com.itmatcher.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * UserRepository Class - The repository for calling functions for Users
 *
 * @author dean, bede, melissa, john, mark and stephen
 * @version 1.0
 *
 */
@Repository
public class UserRepository {
    private NamedParameterJdbcTemplate template;

    @Autowired
    public UserRepository(DataSource ds) {
        template = new NamedParameterJdbcTemplate(ds);
    }

    /**Returns a user based on the username presented
     * @param username a string containing a users username
     * @return returns a user if one is found matching the username*/
    public Optional<User> getUserByUserName(String username) {
        Map<String, Object> params = new HashMap<>();
        params.put("username", username);

        String sql = "SELECT * FROM tblUser WHERE username=:username";

        List<User> list = template.query(
                sql,
                params,
                userMapper);

        if (list != null && !list.isEmpty()) {
            return Optional.of(list.get(0));
        }

        return Optional.empty();
    }

    /**Registers the user to the application
     * @param user a user created through the user class*/
    public void registerUser(User user) {
        Map<String, Object> params = new HashMap<>();
        params.put("username", user.getUsername());
        params.put("password", user.getPassword());
        params.put("salt", user.getSalt());
        params.put("accountType", user.getAccountType());
        params.put ("firstName",user.getFirstName());
        params.put("lastName",user.getLastName());

        String sql = "insert into tblUser (username, password, salt, accountType, firstName, lastName, email) values (:username, :password, :salt, :accountType ,:firstName, :lastName, :username)";

        template.update(sql, params);
    }


    private RowMapper<User> userMapper = (rs, rowNum) -> {
        User u = new User();

        u.setId(rs.getInt("id"));
        u.setUsername(rs.getString("username"));
        u.setPassword(rs.getString("password"));
        u.setSalt(rs.getString("salt"));
        u.setAccountType(rs.getString("accountType"));
        u.setFirstName(rs.getString("firstName"));
        u.setLastName(rs.getString("lastName"));
        return u;
    };
}
