package cn.itcast.dao.impl;

import cn.itcast.dao.ProvinceDao;
import cn.itcast.domain.ProvinceBean;
import cn.itcast.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<ProvinceBean> findAll() {
        String sql = "select * from province ";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<ProvinceBean>(ProvinceBean.class));
    }
}
