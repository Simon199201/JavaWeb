package cn.itcast.case1.dao;

import cn.itcast.case1.domain.User;

import java.util.List;

public interface UserDao {

    User findUser(User user);
    List<User> findAllUser();

    void addUser(User user);

    void delUserById(String id);

    User findUserById(String id);
}
