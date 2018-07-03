package com.eslamwaheed.www.intcoretask.apimodels.modelsimplementations;

import com.eslamwaheed.www.intcoretask.apimodels.modelinterfaces.MovieInt;
import com.eslamwaheed.www.intcoretask.apimodels.retrofit.ApiClient;
import com.eslamwaheed.www.intcoretask.apimodels.retrofit.MoviesApiInterface;
import com.eslamwaheed.www.intcoretask.mainscreen.retrofitcallback.GetMoviesCallback;
import com.eslamwaheed.www.intcoretask.utils.BaseUrlProvider;

public class MovieImpl implements MovieInt {
    @Override
    public void getMovies(String api_key, String sort_by) {
        MoviesApiInterface moviesApiInterface = ApiClient.buildeService(MoviesApiInterface.class, BaseUrlProvider.Movies_Base_URL);
        moviesApiInterface.getMovies(api_key, sort_by).enqueue(new GetMoviesCallback());
    }
}
