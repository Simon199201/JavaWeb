package cn.itcast.case_.service;

import cn.itcast.case_.domain.User;

import java.util.List;

public interface UserListService {
    List<User> findAllUser();
}