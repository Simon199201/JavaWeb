package cn.itcast.homework.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * /**
 * * 【代码题】
 * * 自定义JDBCUtils工具类，要求如下：
 * *
 * * 1. 提供静态代码块加载配置文件，初始化连接池对象
 * *
 * * 2.获取连接方法：通过数据库连接池获取连接
 * *
 * * 3.获取连接池的方法
 */

public class JDBCUtil {
    //定义一个数据库连接池
    private static DataSource ds;

    static {
        try {
            Properties pro = new Properties();

            pro.load(JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static DataSource getDs() {
        return ds;
    }
}
