package com.codeup.politicianlister.models;

import com.codeup.politicianlister.Config.Config;
import com.codeup.politicianlister.dao.MySQLPoliticianDao;

import java.util.List;

public class Politician {
    private Long id;
    private String name;
    private String description;
    private Long userId;
    private String wikiLink;
    private List<Party> parties;

    public Politician(Long id, String name, String description, String wiki_link, Long user_id) {
        Config config = new Config();
        MySQLPoliticianDao mySQLPoliticianDao = new MySQLPoliticianDao(config);
        this.id = id;
        this.name = name;
        this.description = description;
        this.wikiLink = wiki_link;
        this.userId = user_id;
        this.parties = mySQLPoliticianDao.getPoliticianParties(id);
    }

    public Politician(String name, String description, String wiki_link, Long user_id) {
        this.name = name;
        this.description = description;
        this.wikiLink = wiki_link;
        this.userId = user_id;
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
