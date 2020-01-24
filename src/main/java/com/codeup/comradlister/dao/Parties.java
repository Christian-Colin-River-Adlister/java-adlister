package com.codeup.comradlister.dao;

import com.codeup.comradlister.models.Comrad;
import com.codeup.comradlister.models.Party;

import java.util.List;

public interface Parties {
    public List<Party> all();
    public Long insert(Party party);
    public Party findByName(String name);
    List<Comrad> getPartyComrads(Long id);
    public Long updade(Party party);
    public Long delete(String name);
}
