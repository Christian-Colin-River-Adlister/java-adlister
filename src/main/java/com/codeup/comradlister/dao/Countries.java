package com.codeup.comradlister.dao;

import com.codeup.comradlister.models.Comrad;
import com.codeup.comradlister.models.Country;
import com.codeup.comradlister.models.User;

import java.util.List;

public interface Countries {
    Country findByName(String name);
    List<Country> all();
    Long insert(Country country);
}
