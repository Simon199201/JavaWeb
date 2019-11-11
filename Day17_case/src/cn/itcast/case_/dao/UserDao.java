package cn.itcast.case_.dao;

import cn.itcast.case_.domain.User;

import java.util.List;

public interface UserDao {
    public List<User> findAllUser();
}
