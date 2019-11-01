package cn.itcast.dao;

import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    public User login(User loginUser) {
        String sql = "select * from user where username = ? and password = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDS());
        try {
            User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
