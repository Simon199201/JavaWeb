package cn.itcast.homework.jdbc;

import cn.itcast.jdbc.bean.Student;
import cn.itcast.jdbc.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
public class JDBCTest16_04 {
    public static void main(String[] args) {
        System.out.println(new JDBCTest16_04().getAllStudent());
    }
    public List<Student> getAllStudent(){
        Connection conn = null;
        List<Student> list = new ArrayList<>();
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
            Student student = null;
            while (resultSet.next()) {
                student = new Student();
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                System.out.println("id is " + id + "\tname is " + name);
                student.setId(id);
                student.setName(name);
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, conn);
        }
        return list;
    }
}
