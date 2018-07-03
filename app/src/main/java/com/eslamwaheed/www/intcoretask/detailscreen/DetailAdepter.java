package com.eslamwaheed.www.intcoretask.detailscreen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eslamwaheed.www.intcoretask.R;
import com.eslamwaheed.www.intcoretask.pojos.Comment;

import java.util.List;

public class DetailAdepter extends RecyclerView.Adapter<DetailAdepter.ViewHolder> {

    private DetailMVP.Presenter presenter;
    private Context context;
    private List<Comment> commentList;

    public DetailAdepter(DetailMVP.Presenter presenter, Context context) {
        this.presenter = presenter;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_list_items, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Comment comment = commentList.get(position);

        holder.textview_comment_name.setText(comment.getName());
        holder.textview_comment_comment.setText(comment.getBody());
        holder.textview_comment_detail_name.setText(comment.getName());
        holder.textview_comment_detail_comment.setText(comment.getBody());
    }

    @Override
    public int getItemCount() {
        if (commentList != null)
            return commentList.size();
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ImageView imageview_comment_image;
        public TextView textview_comment_name;
        public TextView textview_comment_time;
        public TextView textview_comment_comment;
        public ImageView imageview_comment_big_image;
        public TextView textview_comment_heart;
        public TextView textview_comment_comments;
        public ImageView imageview_comment_detail_image;
        public TextView textview_comment_detail_name;
        public TextView textview_comment_detail_comment;

        public ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            this.imageview_comment_image = itemView.findViewById(R.id.imageview_comment_image);
            this.textview_comment_name = itemView.findViewById(R.id.textview_comment_name);
            this.textview_comment_time = itemView.findViewById(R.id.textview_comment_time);
            this.textview_comment_comment = itemView.findViewById(R.id.textview_comment_comment);
            this.imageview_comment_big_image = itemView.findViewById(R.id.imageview_comment_big_image);
            this.textview_comment_heart = itemView.findViewById(R.id.textview_comment_heart);
            this.textview_comment_comments = itemView.findViewById(R.id.textview_comment_comments);
            this.imageview_comment_detail_image = itemView.findViewById(R.id.imageview_comment_detail_image);
            this.textview_comment_detail_name = itemView.findViewById(R.id.textview_comment_detail_name);
            this.textview_comment_detail_comment = itemView.findViewById(R.id.textview_comment_detail_comment);
        }
    }

    public void refreshList(List<Comment> commentList) {
        this.commentList = commentList;
        notifyDataSetChanged();
    }
}
