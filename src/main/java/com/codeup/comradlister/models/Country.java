package com.codeup.comradlister.models;

public class Country {
    private Long id;
    private String name;
    private String continent;
    private int level_of_comradery;

    public Country(Long id, String name, String continent, int level_of_comradery) {
        this.id = id;
        this.name = name;
        this.continent = continent;
        this.level_of_comradery = level_of_comradery;
    }

    public Country(String name, String continent, int level_of_comradery) {
        this.name = name;
        this.continent = continent;
        this.level_of_comradery = level_of_comradery;
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

    public int getLevel_of_comradery() {
        return level_of_comradery;
    }

    public void setLevel_of_comradery(int level_of_comradery) {
        this.level_of_comradery = level_of_comradery;
    }
}
