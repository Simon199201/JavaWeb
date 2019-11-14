package cn.itcast.case1.service;

import cn.itcast.case1.domain.PageBean;
import cn.itcast.case1.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User findUser(User user);
    List<User> findAllUser();

    void addUser(User user);

    void delUserById(String id);

    User findUserById(String id);

    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);

    void delSelectedUsers(String[] strings);
}
