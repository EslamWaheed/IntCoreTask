package com.eslamwaheed.www.intcoretask.mainscreen;

import com.eslamwaheed.www.intcoretask.pojos.Movies;
import com.eslamwaheed.www.intcoretask.pojos.Result;

import java.util.List;

public interface MainMVP {

    interface View {

        void onCardListItemClicked(Result result, int pageId);

        void setResultList(Movies movies);
    }

    interface Presenter {
        void setView(View view);

        void goToDetailActivity(Result result, int pageId);

        void changeFavoriteState();

        void loadMovies(String api_key, String sort_by);

        void register();

        void terminate();
    }

    interface Model {

    }
}
