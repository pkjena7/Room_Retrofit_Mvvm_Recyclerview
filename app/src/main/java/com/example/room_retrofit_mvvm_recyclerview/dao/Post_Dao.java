package com.example.room_retrofit_mvvm_recyclerview.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.room_retrofit_mvvm_recyclerview.model.Post;

import java.util.List;

@Dao
public interface Post_Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Post> posts);

    @Query("SELECT * FROM Posts")
    LiveData<List<Post>> getAllPost();

    @Query("DELETE FROM Posts")
    void deleteAll();
}
