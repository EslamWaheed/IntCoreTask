package com.eslamwaheed.www.intcoretask.detailscreen;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.eslamwaheed.www.intcoretask.R;
import com.eslamwaheed.www.intcoretask.application.App;
import com.eslamwaheed.www.intcoretask.pojos.Comment;
import com.eslamwaheed.www.intcoretask.pojos.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

public class DetailActivity extends AppCompatActivity implements DetailMVP.View {

    @Inject
    DetailMVP.Presenter presenter;

    @Inject
    Context context;

    private ImageView detail_big_image;
    private ImageView detail_small_image;

    private RecyclerView recyclerView;
    private DetailAdepter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ((App) getApplication()).getComponent().inject(this);

        presenter.setView(this);
        recyclerView = findViewById(R.id.detail_recyclerView);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new DetailAdepter(presenter, context);

        recyclerView.setAdapter(adapter);

        detail_big_image = findViewById(R.id.detail_big_image);

        detail_small_image = findViewById(R.id.detail_small_image);

        Result result = (Result) getIntent().getSerializableExtra("movie");

        Picasso.with(this).load("http://image.tmdb.org/t/p/w780" + result.getBackdropPath()).into(detail_big_image);

        Picasso.with(this).load("http://image.tmdb.org/t/p/w92" + result.getPosterPath()).into(detail_small_image);

        int pageId = getIntent().getIntExtra("pageId", 1);

        presenter.loadComments(pageId);
    }

    @Override
    public void onCardListItemClicked() {

    }

    @Override
    public void setCommentList(List<Comment> commentList) {
        adapter.refreshList(commentList);
    }
}
