package com.codeup.comradlister.dao;

import com.codeup.comradlister.models.Comrad;

import java.util.List;

public interface Parties {
    Parties findByName(String name);
    List<Party> all();
    Long insert(Party party);
}
