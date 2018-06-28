package com.eslamwaheed.www.intcoretask.apimodels.retrofit;

import com.eslamwaheed.www.intcoretask.pojos.Movies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesApiInterface {

    @GET("movie")
    Call<Movies> getMovies(@Query("api_key") String api_key, @Query("sort_by") String sort_by);
}
