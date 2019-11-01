package cn.itcast.test;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void testLogin(){
        User user = new User();
        user.setUsername("superbaby");
        user.setPassword("123");
        UserDao userDao = new UserDao();
        User result = userDao.login(user);
        if (result == null) {
            System.out.println("登录失败");
        } else {
            System.out.println("登录成功");
        }
    }
}
