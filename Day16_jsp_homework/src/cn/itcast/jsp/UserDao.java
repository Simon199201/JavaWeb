package cn.itcast.jsp;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    public User login(User loginUser) {
        String sql = "select * from user where username = ? and password = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDS());
        System.out.println("login\t"+loginUser.getUsername()+"\tpassowrd is "+loginUser.getPassword());
        try {
            User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
