package com.kavisid.practical.example.retrofit;

import com.kavisid.practical.example.retrofit.pojo.MovieDetails;
import com.kavisid.practical.example.retrofit.pojo.MultipleResource;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("/api/unknown")
    Call<MultipleResource> doGetListResources();

    @GET("marvel")
    Call<List<MovieDetails>> getMovieDetails();
}
