package com.example.room_retrofit_mvvm_recyclerview.repo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.room_retrofit_mvvm_recyclerview.dao.Post_Dao;
import com.example.room_retrofit_mvvm_recyclerview.database.PostDatabase;
import com.example.room_retrofit_mvvm_recyclerview.model.Post;
import com.example.room_retrofit_mvvm_recyclerview.model.RequestPost;

import java.util.List;

public class PostRepo {

    private PostDatabase postDatabase;
    private LiveData<List<Post>> allPosts;

    public PostRepo(Application application) {
        postDatabase = PostDatabase.getInstance(application);
        allPosts = postDatabase.post_dao().getAllPost();
    }

    public void insert(List<Post> postList) {
        new InsertAsyncTask(postDatabase).execute(postList);
    }

    public LiveData<List<Post>> getPosts() {
        return allPosts;
    }

    static class InsertAsyncTask extends AsyncTask<List<Post>, Void, Void> {
        private Post_Dao post_dao;

        InsertAsyncTask(PostDatabase postDatabase) {
            post_dao = postDatabase.post_dao();
        }

        @Override
        protected Void doInBackground(List<Post>... lists) {
            post_dao.insert(lists[0]);
            return null;
        }
    }
}
