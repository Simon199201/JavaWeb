package cn.itcast.session;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class GoodsDao {
    public GoodBean query(String pid) {
        String sql = "select * from goods where pid = ? ";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDS());
        System.out.println("id is " + pid);
        try {
            GoodBean goodBean = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<GoodBean>(GoodBean.class), pid);
            return goodBean;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
