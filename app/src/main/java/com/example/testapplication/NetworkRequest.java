package com.example.testapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkRequest {
    private static NetworkRequest request;
    private static final String BASE_URL = "https://api.github.com";
    private Retrofit retrofit;

    private NetworkRequest() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkRequest getRequest(){
        if(request == null){
            request = new NetworkRequest();
        }
        return request;
    }

    public GithubAPI getGithubApi(){
        return  retrofit.create(GithubAPI.class);
    }


}
