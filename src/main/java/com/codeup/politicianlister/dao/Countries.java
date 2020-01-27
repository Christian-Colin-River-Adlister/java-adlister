package com.codeup.politicianlister.dao;

import com.codeup.politicianlister.models.Country;
import com.codeup.politicianlister.models.Party;

import java.util.List;

public interface Countries {
    Country findByName(String name);
    List<Country> all();
    Long insert(Country country);
    List<Party> getPartiesFromId(Long id);
    Country findById(Long id);
}
