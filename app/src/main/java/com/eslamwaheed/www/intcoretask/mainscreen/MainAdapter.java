package com.eslamwaheed.www.intcoretask.mainscreen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.eslamwaheed.www.intcoretask.R;
import com.eslamwaheed.www.intcoretask.pojos.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private MainMVP.Presenter presenter;
    private Context context;
    private List<Result> resultList;

    public MainAdapter(MainMVP.Presenter presenter, Context context) {
        this.presenter = presenter;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_list_items, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Result result = resultList.get(position);

        Picasso.with(context).load("http://image.tmdb.org/t/p/w185" + result.getPosterPath()).into(holder.imageview_movieimage);
        holder.textview_moviename.setText(result.getTitle());
        holder.ratingbar_movierate.setRating(result.getVoteCount() / 2);

        holder.imagebutton_movieasfavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.changeFavoriteState();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (resultList != null)
            return resultList.size();
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ImageView imageview_movieimage;
        public TextView textview_moviename;
        public RatingBar ratingbar_movierate;
        public ImageButton imagebutton_movieasfavorite;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            this.imageview_movieimage = itemView.findViewById(R.id.imageview_movieimage);
            this.textview_moviename = itemView.findViewById(R.id.textview_moviename);
            this.ratingbar_movierate = itemView.findViewById(R.id.ratingbar_movierate);
            this.imagebutton_movieasfavorite = itemView.findViewById(R.id.imagebutton_movieasfavorite);
        }
    }

    public void refreshList(List<Result> resultList) {
        this.resultList = resultList;
        notifyDataSetChanged();
    }
}
