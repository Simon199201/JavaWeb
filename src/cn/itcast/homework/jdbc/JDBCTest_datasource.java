package cn.itcast.homework.jdbc;

import cn.itcast.jdbc.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 【代码题】
 * 自定义JDBCUtils工具类，要求如下：
 * <p>
 * 1. 提供静态代码块加载配置文件，初始化连接池对象
 * <p>
 * 2.获取连接方法：通过数据库连接池获取连接
 * <p>
 * 3.获取连接池的方法
 */
public class JDBCTest_datasource {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement pstm = null;
        try {
            connection = JDBCUtil.getConnection();
            pstm = connection.prepareStatement("insert into student5 values(null,'王五')");
            int count = pstm.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstm, connection);
        }

    }
}
