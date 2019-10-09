package cn.itcast.homework.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 【代码题】
 * 创建一张学生表(id，姓名，性别)
 * <p>
 * 1.向学生表中添加1条记录，因为主键是自动增长，所以只需指定姓名和性别字段。
 * <p>
 * 2.将id为2的用户，姓名更新为"猪八戒"
 */
public class JDBCTest_11 {
    public static void main(String[] args) {
        //1注册驱动
        Connection conn = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
            //3获取执行语句
            statement = conn.createStatement();
            //编写sql
            String sql = "insert  into student4 values (null ,'猪八戒2',1)";
            //5执行sql
            int count = statement.executeUpdate(sql);
            //6处理结果
            System.out.println(count);
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7释放资源
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
