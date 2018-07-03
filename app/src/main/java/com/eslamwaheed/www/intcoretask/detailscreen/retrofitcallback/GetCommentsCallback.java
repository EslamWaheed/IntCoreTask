package com.eslamwaheed.www.intcoretask.detailscreen.retrofitcallback;

import com.eslamwaheed.www.intcoretask.pojos.Comment;
import com.eslamwaheed.www.intcoretask.utils.CustomEvent;
import com.eslamwaheed.www.intcoretask.utils.CustomEventType;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class GetCommentsCallback implements retrofit2.Callback<java.util.List<com.eslamwaheed.www.intcoretask.pojos.Comment>> {
    @Override
    public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
        if (response.body() != null) {
            EventBus.getDefault().post(new CustomEvent(CustomEventType.GET_COMMENTS, response.body()));
        } else {
            System.out.println("GetCommentsCallback Nulllllllllll");
        }
    }

    @Override
    public void onFailure(Call<List<Comment>> call, Throwable t) {
        System.out.println("GetCommentsCallback Eroooorrrrrrr/n");
        System.out.println("Error Message >>> " + t.getMessage());
    }
}
