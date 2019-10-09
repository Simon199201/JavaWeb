package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //导入jar包
        //注册驱动
        Class<?> cls = Class.forName("com.mysql.jdbc.Driver");
        //获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
        //获取Statement对象
        Statement statement = connection.createStatement();
        //编写sql语句
        String mysql = "update stu5 set name = 'simon1' where id = 1";
        //执行程序获取返回值
        int result = statement.executeUpdate(mysql);
        //处理结果
        System.out.println(result);
        //释放资源
        statement.close();
        connection.close();
    }
}
