package cn.itcast.case1.dao;

import cn.itcast.case1.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    User findUser(User user);
    List<User> findAllUser();

    void addUser(User user);

    void delUserById(String id);

    User findUserById(String id);

    int findTotalCount(Map<String, String[]> condition);

    List<User> findByPage(int start, Integer rows, Map<String, String[]> condition);
}
