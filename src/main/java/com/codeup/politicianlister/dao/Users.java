package com.codeup.politicianlister.dao;

import com.codeup.politicianlister.models.User;

import java.util.List;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);
    List<User> all();
}
