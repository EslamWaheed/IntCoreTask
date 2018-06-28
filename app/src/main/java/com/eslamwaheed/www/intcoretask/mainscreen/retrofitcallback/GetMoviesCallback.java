package com.eslamwaheed.www.intcoretask.mainscreen.retrofitcallback;

import com.eslamwaheed.www.intcoretask.pojos.Movies;
import com.eslamwaheed.www.intcoretask.utils.CustomEvent;
import com.eslamwaheed.www.intcoretask.utils.CustomEventType;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Response;

public class GetMoviesCallback implements retrofit2.Callback<Movies> {
    @Override
    public void onResponse(Call<Movies> call, Response<Movies> response) {
        if (response.body() != null) {
            EventBus.getDefault().post(new CustomEvent(CustomEventType.GET_MOVIES, response.body()));
        } else {
            System.out.println("GetMoviesCallback Nulllllllllll");
        }
    }

    @Override
    public void onFailure(Call<Movies> call, Throwable t) {
        System.out.println("GetMoviesCallback Eroooorrrrrrr/n");
        System.out.println("Error Message >>> " + t.getMessage());
    }
}
