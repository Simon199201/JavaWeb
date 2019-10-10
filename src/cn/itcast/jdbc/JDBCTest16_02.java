package cn.itcast.jdbc;

import cn.itcast.jdbc.bean.Student;
import cn.itcast.jdbc.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 编写方法，通过ID查询指定学号的学生信息，并封装成Student对象返回
 */
public class JDBCTest16_02 {
    public static void main(String[] args) {
        System.out.println(new JDBCTest16_02().getStudentById(2));
    }

    public Student getStudentById(int sid){
        Connection conn = null;
        Student student = null;

        try {
            conn = JDBCUtils.getConnection();

            //查询所有的学生信息
            String sql = "select * from student5 where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, sid);

//            boolean execute = preparedStatement.execute();
//            System.out.println(execute);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                student = new Student();
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                System.out.println("id is " + id + "\tname is " + name);
                student.setId(id);
                student.setName(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, conn);
        }
        return student;
    }
}
