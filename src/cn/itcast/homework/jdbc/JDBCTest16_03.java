package cn.itcast.homework.jdbc;

import cn.itcast.jdbc.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 编写方法，通过ID删除指定学号的学生，并且返回删除的行数
 */
public class JDBCTest16_03 {
    public static void main(String[] args) {
        System.out.println(new JDBCTest16_03().deleteStudentById(2));
    }

    public int deleteStudentById(int sid){
        Connection conn = null;

        try {
            conn = JDBCUtils.getConnection();

            //查询所有的学生信息
            String sql = "delete from student5 where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, sid);

//            boolean execute = preparedStatement.execute();
//            System.out.println(execute);

            int count = preparedStatement.executeUpdate();
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, conn);
        }
        return -1;
    }
}
