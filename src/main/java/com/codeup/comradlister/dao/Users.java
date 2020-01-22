package com.codeup.comradlister.dao;

import com.codeup.comradlister.models.User;

import java.util.List;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);
    List<User> all();
}
