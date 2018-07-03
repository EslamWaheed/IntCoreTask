package com.eslamwaheed.www.intcoretask.apimodels.retrofit;

import com.eslamwaheed.www.intcoretask.pojos.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CommentsApiInterface {

    @GET("comments")
    Call<List<Comment>> getComments(@Query("postId") int postId);
}
