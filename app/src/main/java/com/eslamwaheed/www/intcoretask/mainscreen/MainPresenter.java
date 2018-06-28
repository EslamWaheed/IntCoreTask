package com.eslamwaheed.www.intcoretask.mainscreen;

import android.support.annotation.Nullable;

import com.eslamwaheed.www.intcoretask.apimodels.modelinterfaces.MovieInt;

import org.greenrobot.eventbus.EventBus;

public class MainPresenter implements MainMVP.Presenter {

    @Nullable
    private MainMVP.View view;
    private MovieInt movie;

    public MainPresenter(MovieInt movie) {
        this.movie = movie;
        EventBus.getDefault().register(this);
    }

    @Override
    public void setView(MainMVP.View view) {
        this.view = view;
    }

    @Override
    public void goToDetailActivity() {
        view.onCardListItemClicked();
    }

    @Override
    public void changeFavoriteState() {

    }

    @Override
    public void loadMovies(String api_key, String sort_by) {
        movie.getMovies(api_key, sort_by);
    }


    @Override
    public void register() {
        if (!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
    }

    @Override
    public void terminate() {
        EventBus.getDefault().unregister(this);
    }
}
