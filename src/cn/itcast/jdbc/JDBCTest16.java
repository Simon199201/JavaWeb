package cn.itcast.jdbc;

import cn.itcast.jdbc.util.JDBCUtils;

import java.sql.*;

/**
 * 使用PreparedStatement对象完成数据库的增删改查
 * <p>
 * 1.添加一个学生到学生表
 * <p>
 * 2.删除id=1的学生信息
 * <p>
 * 3.修改id=2学生的姓名为”jack”
 * <p>
 * 4.查询所有的学生信息
 */
public class JDBCTest16 {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            //添加一张学生表
//            String sql = "create table student5(id int primary key auto_increment,nama varchar(20))";
            //添加一个学生到学生表
//            String sql = "insert into student5 values(null,'zhangsan')";
            //删除id=1的学生信息
//              String sql = "delete from student5 where id = ?";

//            PreparedStatement preparedStatement = conn.prepareStatement(sql);
//            preparedStatement.setInt(1, 1);


            //修改id=2学生的姓名为”jack”
//            String sql = "update student5 set name = ? where id = 2 ";
//            PreparedStatement preparedStatement = conn.prepareStatement(sql);
//            preparedStatement.setString(1, "jack");


            //查询所有的学生信息
            String sql = "select * from student5 ";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);


//            boolean execute = preparedStatement.execute();
//            System.out.println(execute);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                System.out.println("id is " + id + "\tname is " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, conn);
        }
    }
}
