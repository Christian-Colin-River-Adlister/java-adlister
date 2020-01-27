package com.codeup.politicianlister.dao;

import com.codeup.politicianlister.models.Politician;
import com.codeup.politicianlister.models.Party;

import java.util.List;

public interface Politicians {
    Politician findByName(String name);
    List<Politician> all();
    Long insert(Politician politician);
    List<Party> getPoliticianParties(Long id);
    Long insertPoliticianParty(Politician politician, Party party);
    public Long update(Politician politician);
    public Long delete(String name);
}
