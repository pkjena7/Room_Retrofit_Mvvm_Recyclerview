package com.example.room_retrofit_mvvm_recyclerview.repo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroRepo {


    private static String Base_Url = "https://jsonplaceholder.typicode.com/";

    public static Retrofit retrofit;

    public static Retrofit getRetoClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Base_Url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
