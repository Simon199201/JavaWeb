package cn.itcast.case1.service.impl;

import cn.itcast.case1.dao.UserDao;
import cn.itcast.case1.dao.impl.UserDaoImpl;
import cn.itcast.case1.domain.User;
import cn.itcast.case1.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public User findUser(User user) {
        UserDao userDao = new UserDaoImpl();
        return userDao.findUser(user);
    }
    @Override
    public List<User> findAllUser() {
        UserDao userDao = new UserDaoImpl();
        return userDao.findAllUser();
    }
}