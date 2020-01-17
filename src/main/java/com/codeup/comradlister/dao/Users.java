package com.codeup.comradlister.dao;

import com.codeup.comradlister.models.User;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);
}
