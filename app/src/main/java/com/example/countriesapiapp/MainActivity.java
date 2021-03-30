 package com.example.countriesapiapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

 public class MainActivity extends AppCompatActivity implements itemClickListener {
     EditText editsearch;
     RecyclerView listView;
     public static List<Countries> countriesList = new ArrayList<>();
     Countries countries;
     MyAdapter adapter;
     private String url;
     private String languages,capital,flagurl,countryName,region,subregion,population;


 /// private AsyncTask mytask;
  private Bitmap bitmap= null;



     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView= (RecyclerView) findViewById(R.id.list_item);
        listView.setHasFixedSize(true);
       listView.setLayoutManager(new LinearLayoutManager(this));
        getSupportActionBar().setTitle("CountriesApiApp");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        fetchData();
        checkConnection();


    }

     private void checkConnection() {
         ConnectivityManager manager = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
         NetworkInfo activenetwork = manager.getActiveNetworkInfo();
         if (null != activenetwork){
             if (activenetwork.getType() == ConnectivityManager.TYPE_WIFI){
                 fetchData();
             } if (activenetwork.getType() == ConnectivityManager.TYPE_MOBILE){
                 fetchData();
             }
         }else {
             Toast.makeText(this, "No Network", Toast.LENGTH_SHORT).show();
         }
     }

     @Override
     public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         if(item.getItemId()==android.R.id.home)
            finish();
         return super.onOptionsItemSelected(item);
     }

     private void fetchData() {
       String  url ="https://restcountries.eu/rest/v2/region/asia";
         StringRequest request = new StringRequest(Request.Method.GET, url,
                 new Response.Listener<String>() {
                     @Override
                     public void onResponse(String response) {
                         try {
                            // String languages = null;
                             JSONArray jsonArray= new JSONArray(response);
                             for(int i = 0;i<=jsonArray.length()-1;i++){
                                 JSONObject jsonObject = jsonArray.getJSONObject(i);
                                 JSONArray language = jsonObject.getJSONArray("languages");
                                 for (int j = 0; j<=language.length()-1;j++){
                                     JSONObject languageobject = language.getJSONObject(j);
                                     languages = languageobject.getString("name");

                                 }

                                 countryName = jsonObject.getString("name");

                                  capital = jsonObject.getString("capital");

                                 region = jsonObject.getString("region");
                                subregion = jsonObject.getString("subregion");
                                  population = jsonObject.getString("population");
                                  flagurl = jsonObject.getString("flag");
                                 final Countries countries = new Countries(countryName,capital,flagurl,region,subregion,population,"55",languages);
                             //    final Country country = new Country(countryName,capital,flagurl,region,subregion,population,languages);
                                // String border = jsonObject.getString("");
                                countriesList.add(countries);
                          //     mytask = new DownloadTask().execute(stringtoURL(flagurl));





                             }
                             adapter = new MyAdapter(MainActivity.this,countriesList);
                             adapter.setOnItemClickListener(MainActivity.this);
                             listView.setAdapter(adapter);

                         } catch (JSONException e) {
                             e.printStackTrace();
                         }

                     }
                 }, new Response.ErrorListener() {
             @Override
             public void onErrorResponse(VolleyError error) {
                 Toast.makeText(MainActivity.this, "error", Toast.LENGTH_LONG).show();
             }
         });
         RequestQueue requestQueue= Volley.newRequestQueue(this);
         requestQueue.add(request);
     }

     @Override
     public void onItemClick(int position) {
         Intent intent = new Intent(getApplicationContext(),DetailActivity.class);

         Countries countries = countriesList.get(position);
         intent.putExtra("name",countries.getName());
         intent.putExtra("capital",countries.getCapital());
         intent.putExtra("flagurl",countries.getFlagurl());
         intent.putExtra("region",countries.getRegion());
         intent.putExtra("subregion",countries.getSubregion());
         intent.putExtra("population",countries.getPopulation());
         intent.putExtra("language",countries.getLanguage());
        startActivity(intent);
     }


}
