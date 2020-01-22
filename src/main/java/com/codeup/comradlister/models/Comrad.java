package com.codeup.comradlister.models;

import java.util.ArrayList;
import java.util.List;

public class Comrad {
    private Long id;
    private String name;
    private String description;
    private Long user_id;
    private List<Party> parties;

    public Comrad(Long id, String name, String description, Long user_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.user_id = user_id;
    }

    public Comrad(Long id,String name, String description, Long user_id, List<Party> parties) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.user_id = user_id;
        this.parties = parties;
    }

    public Comrad(String name, String description, Long user_id, List<Party> parties) {
        this.name = name;
        this.description = description;
        this.user_id = user_id;
        this.parties = parties;
    }

    public Comrad(String test){
        this.name = test;
        this.description = "description";
        this.user_id = 0L;
        this.parties = new ArrayList<Party>();
        this.parties.add(new Party("test 1"));
        this.parties.add(new Party("test 2"));
        this.parties.add(new Party("test 3"));
        this.parties.add(new Party("test 4"));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public List<Party> getParties() {
        return parties;
    }

    public void setParties(List<Party> parties) {
        this.parties = parties;
    }
}
