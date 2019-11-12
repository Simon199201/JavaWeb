package cn.itcast.case1.dao.impl;

import cn.itcast.case1.dao.UserDao;
import cn.itcast.case1.domain.User;
import cn.itcast.case1.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User findUser(User user) {
//        String sql = "select * from user where username = ? and password = ?";
//        User user1 = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class));
//        return user1;
        System.out.println("simon username is "+user.getUsername());
        System.out.println("simon password is "+user.getPassword());
        try {
            String sql = "select * from user where username = ? and password = ?";
            User login_user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getUsername(), user.getPassword());
            return login_user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public List<User> findAllUser() {
        String sql = "select * from user";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }
}
