package com.example.engahmedatef.ahmed_bahaatask_1.repository;

import android.util.Log;

import com.example.engahmedatef.ahmed_bahaatask_1.data.local.PostModel_Room;
import com.example.engahmedatef.ahmed_bahaatask_1.data.local.Posts;
import com.example.engahmedatef.ahmed_bahaatask_1.ui.main_screen.MainActivity;

import java.util.List;

import static com.example.engahmedatef.ahmed_bahaatask_1.ui.main_screen.MainActivity.posts_;
import static com.example.engahmedatef.ahmed_bahaatask_1.ui.main_screen.MainActivity.roomDataBase;

public class RepositoryImp implements Repositry.RepoDB {

    private final String TAG = this.getClass().getName();
    private MainActivity mainActivity;
    private Posts posts;

    public RepositoryImp() {
        mainActivity = new MainActivity();
        posts = new Posts();
    }
    @Override
    public void add(PostModel_Room postModel_room) {
        Log.e(TAG, "AddDataRoomDB");
        roomDataBase.oper().AddUser(postModel_room);
    }
    @Override
    public void getAllPosts() {
        Log.e(TAG, "GetDataDB");
        posts_ = roomDataBase.oper().GetData();
        mainActivity.recyclerOfflineRoom(posts_);
    }
    @Override
    public void updateData(int id, String title, String body) {
        Log.e(TAG, "updateDataDB");
    }
    @Override
    public void DeleteAllPosts() {
        Log.e(TAG, "DeleteAllPostsToDB");
        roomDataBase.oper().Delete();
    }
}