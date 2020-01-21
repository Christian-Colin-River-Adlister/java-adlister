package com.codeup.comradlister.dao;

import com.codeup.comradlister.models.Comrad;
import com.codeup.comradlister.models.User;

import java.util.List;

public interface Countries {
    Countries findByName(String name);
    List<Countries> all();
    Long insert(Countries countries);
}
