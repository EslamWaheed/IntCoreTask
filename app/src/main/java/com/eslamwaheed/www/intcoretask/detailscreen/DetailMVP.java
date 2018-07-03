package com.eslamwaheed.www.intcoretask.detailscreen;

import com.eslamwaheed.www.intcoretask.pojos.Comment;

import java.util.List;

public interface DetailMVP {

    interface View {

        void onCardListItemClicked();

        void setCommentList(List<Comment> commentList);
    }

    interface Presenter {
        void setView(View view);

        void loadComments(int postId);

        void register();

        void terminate();
    }

    interface Model {

    }
}
