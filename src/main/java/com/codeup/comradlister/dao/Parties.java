package com.codeup.comradlister.dao;

import com.codeup.comradlister.models.Party;

import java.util.List;

public interface Parties {
    public List<Party> all();
    public Long insert(Party party);
    public Party findByName(String name);
}
