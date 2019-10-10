package cn.itcast.jdbc;

import java.sql.*;

/**
 * 确保数据库student表中有2条以上的记录，查询所有的学员信息，输出到控制台
 */
public class JDBCTest12 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", "root");
            stat = conn.createStatement();
            String mysql = "select * from student";
            resultSet = stat.executeQuery(mysql);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");
                int age = resultSet.getInt(4);
                System.out.println("id is " + id + "\tname is " + name + "\tcity is " + city + "\tage is " + age);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stat != null) {
                try {
                    stat.close();
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
