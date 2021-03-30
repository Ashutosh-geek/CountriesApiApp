package com.example.countriesapiapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Country.class, version = 1)
public abstract class CountriesRoomDatabase extends RoomDatabase {

    public abstract CountriesDao taskDao();
    private static volatile CountriesRoomDatabase countriesRoomInstance;

    static CountriesRoomDatabase getDatabase(Context context){
        if (countriesRoomInstance == null){
            synchronized (CountriesRoomDatabase.class){
                if (countriesRoomInstance == null){
                    countriesRoomInstance = Room.databaseBuilder(context.getApplicationContext(),CountriesRoomDatabase.class,"country_databasee")
                            .allowMainThreadQueries()
                            .build();

                }
            }
        }
        return countriesRoomInstance;
    }
}
