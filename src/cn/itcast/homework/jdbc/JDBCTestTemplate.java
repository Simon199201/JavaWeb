package cn.itcast.homework.jdbc;

import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 【代码题】
 * 使用mysql创建一个用户表(包含字段：用户编号，用户名，性别，地址)
 * <p>
 * 然后使用JdbcTemplate完成以下需求:
 * <p>
 * 1.向用户表添加多条用户记录
 * <p>
 * 2.更新用户表中id为2的记录，修改性别和居住地
 * <p>
 * 3.删除用户表中id为3的记录
 * <p>
 * 4.查询用户表的所有用户数据,查询结果是一个集合，集合中存放所有的用户对象
 */
public class JDBCTestTemplate {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDs());

    @Test
    public void test1() {
        String sql = "insert into student5 values (?,?)";
        int count = template.update(sql, null, "hanwei");
        System.out.println(count);
    }

    @Test
    public void test2() {
        String sql = "update student5 set name = ? where id = ?";
        int count = template.update(sql, "songzi", 3);
        System.out.println(count);
    }

    @Test
    public void test3() {
        String sql = "delete from student5  where id = ?";
        int count = template.update(sql, 4);
        System.out.println(count);
    }

    @Test
    public void test4() {
        String sql = "select * from student5 ";
        List<Student5> query = template.query(sql, new BeanPropertyRowMapper<>(Student5.class));
        System.out.println(query);
    }
}
