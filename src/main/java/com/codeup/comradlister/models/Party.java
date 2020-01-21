package com.codeup.comradlister.models;

public class Party {
    private Long id;
    private String name;
    private String description;
    private String dateFounded;
    private String dateDissolved;
    private Long countryID;
    private String flagUrl;

    public Party(){}

    public Party(Long id, String name, String description, String dateFounded, String dateDissolved, Long countryID, String flagUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateFounded = dateFounded;
        this.dateDissolved = dateDissolved;
        this.countryID = countryID;
        this.flagUrl = flagUrl;
    }

    public Party(String name, String description, String dateFounded, String dateDissolved, Long countryID, String flagUrl) {
        this.name = name;
        this.description = description;
        this.dateFounded = dateFounded;
        this.dateDissolved = dateDissolved;
        this.countryID = countryID;
        this.flagUrl = flagUrl;
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

    public String getDateFounded() {
        return dateFounded;
    }

    public void setDateFounded(String dateFounded) {
        this.dateFounded = dateFounded;
    }

    public String getDateDissolved() {
        return dateDissolved;
    }

    public void setDateDissolved(String dateDissolved) {
        this.dateDissolved = dateDissolved;
    }

    public Long getCountryID() {
        return countryID;
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
