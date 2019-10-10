package cn.itcast.homework.jdbc;

import cn.itcast.jdbc.util.JDBCUtils;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 【代码题】
 * 1.在数据库创建部门表和员工表，包含字段如下：
 * <p>
 * 部门表包含字段有：部门编号，部门名称(唯一且不能为空)
 * <p>
 * 员工表包含字段有：员工编号，员工姓名(唯一且不能为空)，员工性别，员工职位，员工工资，入职日期。部门编号(外键)
 * <p>
 * 2.先添加多个部门数据，再添加多条员工数据
 * <p>
 * 3.编写方法接收一个员工编号和工资两个参数，方法内将指定编号的员工工资修改为新的工资。
 * <p>
 * 4.编写方法查询指定职位所有员工的信息，返回List<Employee>集合。
 * <p>
 * 5.编写方法查询指定姓名的员工信息，返回Employee对象。
 * <p>
 * 6.编写方法根据员工姓名删除指定的员工信息。
 * <p>
 * 7.编写方法查询所有姓张员工的工资并输出在控制台，输出格式如下：
 * <p>
 * 张三=10000
 * <p>
 * 张飞=20000
 * <p>
 * …………………
 * <p>
 * 8.编写方法接收一个工资参数，方法内查询工资大于等于传入的工资的员工，返回符合条件所有员工信息List<Employee>集合。
 * <p>
 * 9.编写方法查询指定部门的所有员工信息，返回List<Employee>集合
 */
public class JDBCTest16_06 {
    //编写方法查询指定职位所有员工的信息，返回List<Employee>集合。
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(new JDBCTest16_06().getAllEmpByDName("android"));
    }

    public List<Emp> getAllEmpByDName(String job) {
        List<Emp> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from emp where job = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, job);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Emp emp = new Emp();
                int eid = resultSet.getInt(1);
                String ename = resultSet.getString(2);
                int sex = resultSet.getInt(3);
                String j = resultSet.getString(4);
                double salary = resultSet.getDouble(5);
                Date join_time = resultSet.getDate(6);
                int dept_id = resultSet.getInt(7);
                emp.setId(eid);
                emp.setEname(ename);
                emp.setSex(sex);
                emp.setJob(j);
                emp.setSalary(salary);
                emp.setJoin_time(join_time);
                emp.setDept_id(dept_id);
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(resultSet,preparedStatement,connection);
        }
        return list;
    }
}
