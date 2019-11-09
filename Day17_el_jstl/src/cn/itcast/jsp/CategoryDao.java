package cn.itcast.jsp;

import org.springframework.beans.BeanWrapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryDao {
    public List<Category> getAllCategory() {
        String sql = "select * from category ";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDS());
        try {
            List<Category> list = jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper<Category>(Category.class));
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
