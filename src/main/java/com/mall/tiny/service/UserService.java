package com.mall.tiny.service;

import com.mall.tiny.mbg.model.User;

import java.util.List;

/**
 * Userservice接口
 * 列出所有
 * 创建
 * 修改
 * 删除
 */
public interface UserService {
    List<User> listAllUser();

    int createUser(User user);

    int updateUser(int id, User user);

    int deleteUser(int id);

    List<User> listUser(int pageNum, int pageSize);

    User getUser(int id);
}
