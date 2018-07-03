package com.eslamwaheed.www.intcoretask.detailscreen;

import android.support.annotation.Nullable;

import com.eslamwaheed.www.intcoretask.apimodels.modelinterfaces.CommentInt;
import com.eslamwaheed.www.intcoretask.pojos.Comment;
import com.eslamwaheed.www.intcoretask.utils.CustomEvent;
import com.eslamwaheed.www.intcoretask.utils.CustomEventType;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

public class DetailPresenter implements DetailMVP.Presenter {

    @Nullable
    private DetailMVP.View view;
    private CommentInt commentInt;

    public DetailPresenter(CommentInt commentInt) {
        this.commentInt = commentInt;
        EventBus.getDefault().register(this);
    }

    @Override
    public void setView(DetailMVP.View view) {
        this.view = view;
    }

    @Override
    public void loadComments(int postId) {
        commentInt.getcomments(postId);
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

    @Subscribe
    public void CommentsListOnLoad(CustomEvent event) {
        if (event.getEventType() == CustomEventType.GET_COMMENTS)
            view.setCommentList((List<Comment>) event.getObject());
    }
}
