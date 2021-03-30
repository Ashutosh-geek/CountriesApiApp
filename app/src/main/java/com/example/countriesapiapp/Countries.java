package com.example.countriesapiapp;

public class Countries {
    private String name,capital,flagurl,region,subregion,population,border,language;
    public Countries(){

    }

    public Countries(String name, String capital, String flagurl, String region, String subregion, String population, String border, String language) {
        this.name = name;
        this.capital = capital;
        this.flagurl = flagurl;
        this.region = region;
        this.subregion = subregion;
        this.population = population;
        this.border = border;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getFlagurl() {
        return flagurl;
    }

    public void setFlagurl(String flagurl) {
        this.flagurl = flagurl;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getBorder() {
        return border;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
