package com.example.room_retrofit_mvvm_recyclerview.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.room_retrofit_mvvm_recyclerview.dao.Post_Dao;
import com.example.room_retrofit_mvvm_recyclerview.model.Post;

@Database(entities = {Post.class}, version = 1)
public abstract class PostDatabase extends RoomDatabase {


    public static String DATABASE_NAME = "ActorDatabase";

    public abstract Post_Dao post_dao();

    private static volatile PostDatabase INSTANCE;

    public static PostDatabase getInstance(Context context) {

        if (INSTANCE == null) {

            synchronized (PostDatabase.class) {
                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(context, PostDatabase.class, DATABASE_NAME)
                            .addCallback(callback)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }


    static Callback callback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateAsyncTask(INSTANCE);
        }
    };

    static class PopulateAsyncTask extends AsyncTask<Void, Void, Void> {

        private Post_Dao post_dao;

        PopulateAsyncTask(PostDatabase postDatabase) {
            post_dao = postDatabase.post_dao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            post_dao.deleteAll();
            return null;
        }
    }


}
