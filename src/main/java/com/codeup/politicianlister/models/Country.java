package com.codeup.politicianlister.models;

public class Country {
    private Long id;
    private String name;
    private String continent;
    private String wiki_link;

    public Country(Long id, String name, String continent, String wiki_link) {
        this.id = id;
        this.name = name;
        this.continent = continent;
        this.wiki_link = wiki_link;
    }

    public Country(String name, String continent, String wiki_link) {
        this.name = name;
        this.continent = continent;
        this.wiki_link = wiki_link;
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

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getWiki_link() {
        return wiki_link;
    }

    public void setWiki_link(String wiki_link) {
        this.wiki_link = wiki_link;
    }
}
