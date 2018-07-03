package com.eslamwaheed.www.intcoretask.apimodels.modelsimplementations;

import com.eslamwaheed.www.intcoretask.apimodels.modelinterfaces.MovieInt;
import com.eslamwaheed.www.intcoretask.apimodels.retrofit.MoviesApiClient;
import com.eslamwaheed.www.intcoretask.apimodels.retrofit.MoviesApiInterface;
import com.eslamwaheed.www.intcoretask.mainscreen.retrofitcallback.GetMoviesCallback;

public class MovieImpl implements MovieInt {
    @Override
    public void getMovies(String api_key, String sort_by) {
        MoviesApiInterface moviesApiInterface = MoviesApiClient.buildeService(MoviesApiInterface.class);
        moviesApiInterface.getMovies(api_key, sort_by).enqueue(new GetMoviesCallback());
    }
}
