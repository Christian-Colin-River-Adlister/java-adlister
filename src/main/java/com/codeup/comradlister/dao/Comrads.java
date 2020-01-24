package com.codeup.comradlister.dao;

import com.codeup.comradlister.models.Comrad;
import com.codeup.comradlister.models.Party;

import java.util.List;

public interface Comrads {
    Comrad findByName(String name);
    List<Comrad> all();
    Long insert(Comrad comrad);
    List<Party> getComradeParties(Long id);
    Long insertComradeParty(Comrad comrad, Party party);
    public Long update(Comrad comrad);
    public Long delete(String name);
}
