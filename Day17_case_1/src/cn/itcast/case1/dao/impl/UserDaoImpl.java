package cn.itcast.case1.dao.impl;

import cn.itcast.case1.dao.UserDao;
import cn.itcast.case1.domain.User;
import cn.itcast.case1.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @Override
    public void addUser(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(),
                user.getEmail(), null, null);
    }

    /**
     * 删除用户
     * 通过id
     * @param id
     */
    @Override
    public void delUserById(String id) {
        String sql = "delete from user where id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public User findUserById(String id) {
        String sql = "select * from user where id = ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        String sql = "select count(*) from user where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keys = condition.keySet();
        List<String> values = new ArrayList<>();
        for (String key : keys) {
            String value = condition.get(key)[0];
            if (key.equals("rows") || key.equals("currentPage") || value==null||value.equals("")) {
                continue;
            }
            sb.append(" and " + key + " like ? ");
            values.add("%"+condition.get(key)[0]+"%");
        }
        System.out.println("findTotalCount sql is " + sb.toString());
        Integer count = jdbcTemplate.queryForObject(sb.toString(), values.toArray(), Integer.class);
        return count;
    }

    @Override
    public List<User> findByPage(int start, Integer rows, Map<String, String[]> condition) {

        String sql = "select * from user where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keys = condition.keySet();
        List<Object> values = new ArrayList<>();
        for (String key : keys) {
            String value = condition.get(key)[0];
            if (key.equals("rows") || key.equals("currentPage") || value==null||value.equals("")) {
                continue;
            }
            sb.append(" and " + key + " like ? ");
            values.add("%"+condition.get(key)[0]+"%");
        }
        sb.append(" limit ?,? ");
        values.add(start);
        values.add(rows);
        System.out.println("findTotalCount sql is " + sb.toString());

        return jdbcTemplate.query(sb.toString(),new BeanPropertyRowMapper<User>(User.class),values.toArray());
    }
}
