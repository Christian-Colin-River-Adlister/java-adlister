package com.codeup.comradlister.dao;

import com.codeup.comradlister.models.Comrad;
import com.codeup.comradlister.models.Party;

import java.util.List;

public interface Comrads {
    Comrad findByName(String name);
    List<Comrad> all();
    Long insert(Comrad comrad);
    List<Party> getComradeParties(Comrad comrad);
    Long insertComradeParty(Comrad comrad, Party party);
}
