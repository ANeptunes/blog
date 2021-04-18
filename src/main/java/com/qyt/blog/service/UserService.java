package com.qyt.blog.service;

import com.qyt.blog.pojo.User;

public interface UserService {
    User checkUser(String username,String password);
}
