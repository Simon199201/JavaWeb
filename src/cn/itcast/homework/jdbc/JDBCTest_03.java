package cn.itcast.homework.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest_03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //导入jar包
        //注册驱动
        Class<?> cls = Class.forName("com.mysql.jdbc.Driver");
        //获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
        //获取执行语句
        Statement statement = connection.createStatement();
        //编写sql语句
        String mysql = "CREATE TABLE student10(\n" +
                "\tid int PRIMARY KEY auto_increment,\n" +
                "\tname VARCHAR(20),\n" +
                "\tsex int \n" +
                ");";
        //执行sql，获取结果
        boolean execute = statement.execute(mysql);
        //处理结果
        System.out.println(execute);
        //释放资源
        statement.close();
        connection.close();

    }
}
