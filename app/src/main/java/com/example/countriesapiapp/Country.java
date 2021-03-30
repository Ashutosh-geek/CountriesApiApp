package com.example.countriesapiapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "countries")
public class Country {
    @PrimaryKey(autoGenerate = true)
    private int id;
  @ColumnInfo(name = "name")
    private String name;
  @ColumnInfo(name = "capital")
    private String capital;
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] image;
  @ColumnInfo(name = "region")
    private String region;
  @ColumnInfo(name = "subregion")
    private String subregion;
  @ColumnInfo(name = "population")
    private String population;
   @ColumnInfo(name = "language")
    private String language;
@Ignore
    public Country(int id, String name, String capital, byte[] image, String region, String subregion, String population, String language) {
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.image = image;
        this.region = region;
        this.subregion = subregion;
        this.population = population;
        this.language = language;
    }

    public Country(String name, String capital, byte[] image, String region, String subregion, String population, String language) {
        this.name = name;
        this.capital = capital;
        this.image = image;
        this.region = region;
        this.subregion = subregion;
        this.population = population;
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
