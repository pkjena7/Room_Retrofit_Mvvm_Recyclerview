package com.example.room_retrofit_mvvm_recyclerview.viewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.room_retrofit_mvvm_recyclerview.model.Post;
import com.example.room_retrofit_mvvm_recyclerview.model.RequestPost;
import com.example.room_retrofit_mvvm_recyclerview.network.PostApi;
import com.example.room_retrofit_mvvm_recyclerview.repo.PostRepo;
import com.example.room_retrofit_mvvm_recyclerview.repo.RetroRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class PostViewModel extends AndroidViewModel {

    public LiveData<List<Post>> posts;
    public PostRepo postRepo;

    public PostViewModel(@NonNull Application application) {
        super(application);
        postRepo = new PostRepo(application);
        posts = postRepo.getPosts();
    }

    public LiveData<List<Post>> getPostObserver() {
        return posts;
    }

    public void makeApiCAll() {

        PostApi postApi = RetroRepo.getRetoClient().create(PostApi.class);
        Call<List<Post>> call = postApi.getAllPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.body() != null) {
                    postRepo.insert(response.body());
                    Log.d(TAG, "onResponse: data is fetching");
                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }

}
