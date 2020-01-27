package com.codeup.politicianlister.models;

import com.codeup.politicianlister.dao.DaoFactory;

import java.sql.Date;

public class Party {
    private Long id;
    private String name;
    private String description;
    private String wiki_link;
    private Long countryID;
    private String flagUrl;

    public Party(){}

    public Party(Long id, String name, String description, String wiki_link , Long countryID, String flagUrl) {
        this.id = id;
        this.name = name;
        this.wiki_link = wiki_link;
        this.description = description;
        this.countryID = countryID;
        this.flagUrl = flagUrl;
    }

    public Party(String name, String description, String wiki_link, Long countryID, String flagUrl) {
        this.name = name;
        this.description = description;
        this.wiki_link = wiki_link;
        this.countryID = countryID;
        this.flagUrl = flagUrl;
    }

    public Party(String name, String description, String wiki_link, Long countryID) {
        this.name = name;
        this.description = description;
        this.wiki_link = wiki_link;
        this.countryID = countryID;
//        this.flagUrl = flagUrl;
    }

//    public Party(String test){
//        this.name = test;
//        this.description = "test party description";
//        this.dateFounded = "1940";
//        this.dateDissolved = "1969";
//        this.countryID = 0L;
//        this.flagUrl = "none";
//    }

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

    public String getWiki_link() {
        return wiki_link;
    }

    public void setWiki_link(String wiki_link) {
        this.wiki_link = wiki_link;
    }

    public Long getCountryID() {
        return countryID;
    }

    public String getCountry() {
        return DaoFactory.getCountriesDao().findById(countryID).getName();
    }


    public void setCountryID(Long countryID) {
        this.countryID = countryID;
    }

    public String getFlagUrl() {
        return flagUrl;
    }

    public void setFlagUrl(String flagUrl) {
        this.flagUrl = flagUrl;
    }

}
