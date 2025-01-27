package com.simone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simone.mapper.UserMapper;
import com.simone.model.User;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void save(User user) {
        userMapper.save(user);
    }

    public User find(Long id) {
        return userMapper.find(id);
    }

    public void delete(Long id) {
        userMapper.delete(id);
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public List<User> search(String name) {
        return userMapper.search("%" + name + "%");
    }
}
