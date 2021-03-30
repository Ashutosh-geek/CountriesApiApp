package com.example.countriesapiapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CountriesDao {
    @Insert
    void insert(Country country);

    @Query("SELECT * FROM  countries ")
    List<Country> getAllCountry();

    @Query("SELECT COUNT(*) FROM countries ")
    int getAllCount();
    @Delete
    void delete(Country country);

    @Update
    void update(Country country);
}
