package com.eslamwaheed.www.intcoretask.mainscreen;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.eslamwaheed.www.intcoretask.R;
import com.eslamwaheed.www.intcoretask.apimodels.retrofit.MovieApiClient;
import com.eslamwaheed.www.intcoretask.application.App;
import com.eslamwaheed.www.intcoretask.pojos.Movies;


import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainMVP.View {

    @Inject
    MainMVP.Presenter presenter;

    @Inject
    Context context;

    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getComponent().inject(this);

        presenter.setView(this);
        recyclerView = findViewById(R.id.main_recyclerView);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MainAdapter(presenter, context);

        recyclerView.setAdapter(adapter);

        presenter.loadMovies(MovieApiClient.API_KEY, "popularity.desc");
    }

    @Override
    public void onCardListItemClicked() {

    }

    @Override
    public void setResultList(Movies movies) {
        adapter.refreshList(movies.getResults());
    }

}
