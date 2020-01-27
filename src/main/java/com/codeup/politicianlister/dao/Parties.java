package com.codeup.politicianlister.dao;

import com.codeup.politicianlister.models.Politician;
import com.codeup.politicianlister.models.Party;

import java.util.List;

public interface Parties {
    public List<Party> all();
    public Long insert(Party party);
    public Party findByName(String name);
    List<Politician> getPartyPoliticians(Long id);
    public Long update(Party party);
    public Long delete(String name);
}
