package com.eslamwaheed.www.intcoretask.apimodels.modelsimplementations;

import com.eslamwaheed.www.intcoretask.apimodels.modelinterfaces.CommentInt;
import com.eslamwaheed.www.intcoretask.apimodels.retrofit.ApiClient;
import com.eslamwaheed.www.intcoretask.apimodels.retrofit.CommentsApiInterface;
import com.eslamwaheed.www.intcoretask.detailscreen.retrofitcallback.GetCommentsCallback;
import com.eslamwaheed.www.intcoretask.utils.BaseUrlProvider;

public class CommentImpl implements CommentInt {
    @Override
    public void getcomments(int postId) {
        CommentsApiInterface commentsApiInterface = ApiClient.buildeService(CommentsApiInterface.class, BaseUrlProvider.Comments_Base_URL);
        commentsApiInterface.getComments(postId).enqueue(new GetCommentsCallback());
    }
}
