package com.example.room_retrofit_mvvm_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.room_retrofit_mvvm_recyclerview.model.Post;
import com.example.room_retrofit_mvvm_recyclerview.repo.PostRepo;
import com.example.room_retrofit_mvvm_recyclerview.viewModel.PostViewModel;

import java.util.List;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    private PostViewModel postViewModel;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);
        postViewModel = new ViewModelProvider(this).get(PostViewModel.class);

        postViewModel.makeApiCAll();

        postViewModel.getPostObserver().observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {

                for (Post post: posts){
                    String content= " ";
                    content +="ID :" +post.getId() + "\n";
                    content +="TITLE :" +post.getTitle() + "\n";
                    content +="BODY :" +post.getBody() + "\n";
                    textView.append(content);
                }
                Log.d(TAG, "onChanged: data is showing");
            }
        });
    }
}