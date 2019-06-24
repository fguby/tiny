package com.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.mall.tiny.mbg.mapper.UserMapper;
import com.mall.tiny.mbg.model.User;
import com.mall.tiny.mbg.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import com.mall.tiny.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * userservice实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listAllUser() {
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public int createUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public int updateUser(int id, User user) {
        user.setUserId(id);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteUser(int id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<User> listUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public User getUser(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

}
