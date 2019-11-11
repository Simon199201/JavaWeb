package cn.itcast.case_.domain.impl;

import cn.itcast.case_.dao.UserDao;
import cn.itcast.case_.dao.impl.UserDaoImpl;
import cn.itcast.case_.domain.User;
import cn.itcast.case_.service.UserListService;

import java.util.List;

public class UserListServiceImpl implements UserListService {
    @Override
    public List<User> findAllUser() {
        UserDao userDao = new UserDaoImpl();
        return userDao.findAllUser();
    }
}
