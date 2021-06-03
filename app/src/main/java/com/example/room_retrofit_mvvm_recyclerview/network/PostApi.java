package com.example.room_retrofit_mvvm_recyclerview.network;

import com.example.room_retrofit_mvvm_recyclerview.model.Post;
import com.example.room_retrofit_mvvm_recyclerview.model.RequestPost;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostApi {

    @GET("posts")
    Call<List<Post>> getAllPosts();
}
