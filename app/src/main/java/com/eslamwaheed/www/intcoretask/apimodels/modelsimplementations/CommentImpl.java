package com.eslamwaheed.www.intcoretask.apimodels.modelsimplementations;

import com.eslamwaheed.www.intcoretask.apimodels.modelinterfaces.CommentInt;
import com.eslamwaheed.www.intcoretask.apimodels.retrofit.CommentsApiClient;
import com.eslamwaheed.www.intcoretask.apimodels.retrofit.MoviesApiClient;
import com.eslamwaheed.www.intcoretask.apimodels.retrofit.CommentsApiInterface;
import com.eslamwaheed.www.intcoretask.detailscreen.retrofitcallback.GetCommentsCallback;

public class CommentImpl implements CommentInt {
    @Override
    public void getcomments(int postId) {
        CommentsApiInterface commentsApiInterface = CommentsApiClient.buildeService(CommentsApiInterface.class);
        commentsApiInterface.getComments(postId).enqueue(new GetCommentsCallback());
    }
}
