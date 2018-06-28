package com.eslamwaheed.www.intcoretask.mainscreen;

import com.eslamwaheed.www.intcoretask.pojos.Movies;

import java.util.List;

public interface MainMVP {

    interface View {

        void onCardListItemClicked();

        void setResultList(Movies movies);
    }

    interface Presenter {
        void setView(View view);

        void goToDetailActivity();

        void changeFavoriteState();

        void loadMovies(String api_key, String sort_by);

        void register();

        void terminate();
    }

    interface Model {

    }
}
