package com.codeup.comradlister.models;

import java.util.ArrayList;
import java.util.List;

public class Comrad {
    private Long id;
    private String name;
    private String description;
    private Long userId;
    private String wikiLink;
    private List<Party> parties;

    public Comrad(Long id, String name, String description,String wiki_link, Long user_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.wikiLink = wiki_link;
        this.userId = user_id;
    }

    public Comrad(Long id,String name, String description,String wiki_link, Long user_id, List<Party> parties) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.wikiLink = wiki_link;
        this.userId = user_id;
        this.parties = parties;
    }

    public Comrad(String name, String description,String wiki_link, Long user_id, List<Party> parties) {
        this.name = name;
        this.description = description;
        this.wikiLink = wiki_link;
        this.userId = user_id;
        this.parties = parties;
    }

    public Comrad(String test){
        this.name = test;
        this.description = "description";
        this.userId = 0L;
        this.parties = new ArrayList<Party>();
        this.wikiLink = "https://en.wikipedia.org/wiki/Communism";
        this.parties.add(new Party("test " + Double.toString(Math.random())));
        this.parties.add(new Party("test " + Double.toString(Math.random())));
        this.parties.add(new Party("test " + Double.toString(Math.random())));
        this.parties.add(new Party("test " + Double.toString(Math.random())));
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Party> getParties() {
        return parties;
    }

    public void setParties(List<Party> parties) {
        this.parties = parties;
    }

    public String getWikiLink() {
        return wikiLink;
    }

    public void setWikiLink(String wiki_link) {
        this.wikiLink = wiki_link;
    }
}
