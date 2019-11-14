package cn.itcast.case1.service.impl;

import cn.itcast.case1.dao.UserDao;
import cn.itcast.case1.dao.impl.UserDaoImpl;
import cn.itcast.case1.domain.PageBean;
import cn.itcast.case1.domain.User;
import cn.itcast.case1.service.UserService;

import java.util.List;
import java.util.Map;

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

    @Override
    public void addUser(User user) {
        UserDao userDao = new UserDaoImpl();
        userDao.addUser(user);
    }

    @Override
    public void delUserById(String id) {
        UserDao userDao = new UserDaoImpl();
        userDao.delUserById(id);
    }

    @Override
    public User findUserById(String id) {
        UserDao userDao = new UserDaoImpl();
        return userDao.findUserById(id);
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        Integer currentPage = Integer.valueOf(_currentPage);
        Integer rows = Integer.valueOf(_rows);
        PageBean<User> pg = new PageBean<>();
        pg.setCurrentPage(currentPage);

        UserDao userDao = new UserDaoImpl();
        int totalCount = userDao.findTotalCount(condition);
        pg.setTotalCount(totalCount);

        pg.setRows(rows);

        int start =  rows * (currentPage-1) ;
        List<User> list = userDao.findByPage(start,rows,condition);

        pg.setList(list);

        int totalPage = totalCount % rows == 0 ? totalCount / rows  : totalCount / rows+1;
        pg.setTotalPage(totalPage);

        return pg;
    }

    @Override
    public void delSelectedUsers(String[] strings) {
        UserDao userDao = new UserDaoImpl();
        for (String uid : strings) {
            userDao.delUserById(uid);
        }
    }
}
