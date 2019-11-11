package cn.itcast.case_.dao.impl;

import cn.itcast.case_.dao.UserDao;
import cn.itcast.case_.domain.User;
import cn.itcast.case_.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAllUser() {
        String sql = "select * from user";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }
}
