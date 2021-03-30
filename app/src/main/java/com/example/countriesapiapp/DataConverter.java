package com.example.countriesapiapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

public class DataConverter {
    public static byte[] convertImagetobytearray(Bitmap bitmap){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,0,stream);
        return stream.toByteArray();
    }

    public static Bitmap convertbytearraytoImages(byte [] array){
        return BitmapFactory.decodeByteArray(array,0,array.length);
    }
}
