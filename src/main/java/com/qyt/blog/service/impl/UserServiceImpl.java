package com.qyt.blog.service.impl;

import com.qyt.blog.dao.UserRepository;
import com.qyt.blog.pojo.User;
import com.qyt.blog.service.UserService;
import com.qyt.blog.util.MD5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, MD5Utils.MD5Code(password));
    }
}
