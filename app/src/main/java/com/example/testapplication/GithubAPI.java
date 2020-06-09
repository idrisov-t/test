package com.example.testapplication;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GithubAPI {
    @GET("/users")
    Call<ArrayList<GithubModel>> getGithubModel();
}
