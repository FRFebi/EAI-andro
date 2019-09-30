package com.example.belajarapi;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class serviceAPI {

    private static Retrofit retrofit;
    private static final String BASE_URL = "http://api.musixmatch.com/";

    public static Retrofit getAPIdata(){
        if(retrofit==null){
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
