package com.example.room_retrofit_mvvm_recyclerview.model;

public class RequestPost {

    String title;
    int user_id;
    String body;

    public RequestPost(String title, int user_id, String body) {
        this.title = title;
        this.user_id = user_id;
        this.body = body;
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
