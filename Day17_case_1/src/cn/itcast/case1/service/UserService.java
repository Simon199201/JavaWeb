package cn.itcast.case1.service;

import cn.itcast.case1.domain.User;

import java.util.List;

public interface UserService {
    User findUser(User user);
    List<User> findAllUser();

}
