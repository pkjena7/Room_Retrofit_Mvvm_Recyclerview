package com.example.room_retrofit_mvvm_recyclerview.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "Posts",indices = @Index(value = {"id"},unique = true))
public class Post {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "Title")
    String title;

    @ColumnInfo(name = "User_Id")
    int user_id;

    @ColumnInfo(name = "Body")
    String body;

    public Post(int id, String title, int user_id, String body) {
        this.id = id;
        this.title = title;
        this.user_id = user_id;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
