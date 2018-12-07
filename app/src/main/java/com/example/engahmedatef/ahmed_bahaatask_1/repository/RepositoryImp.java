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

    //Constructre
    public RepositoryImp() {
        mainActivity = new MainActivity();
        posts = new Posts();
    }

    //Insert data in room database
    @Override
    public void add(PostModel_Room postModel_room) {

        Log.e(TAG, "AddDataRoomDB");
        roomDataBase.oper().AddUser(postModel_room);
    }


//    //Insert data in Sql database
//    @Override
//    public void add(Integer id, String title, String body) {
//
//        Log.e(TAG, "AddDataDB");
//            MainActivity.databaseConnection.insertPost(id, title, body);
//            MainActivity.databaseConnection.insertPost(posts);
//    }

    //get data from room database
    @Override
    public void getAllPosts() {

        Log.e(TAG, "GetDataDB");
//        List<PostModel_Room> postsList1 = roomDataBase.oper().GetData();
        posts_ = roomDataBase.oper().GetData();
        mainActivity.recyclerOfflineRoom(posts_);
    }

    //get data from sql database
//    @Override
//    public void getAllPosts() {
//
//        Log.e(TAG, "GetDataDB");
//        List<Posts> postsList1 = MainActivity.databaseConnection.getAllPosts();
//        mainActivity.recycler(postsList1);
//    }

    //updata data from database
    @Override
    public void updateData(int id, String title, String body) {

        Log.e(TAG, "updateDataDB");
//        MainActivity.databaseConnection.updateData(id, title, body);
    }

    //Remove data from database
    @Override
    public void DeleteAllPosts() {

        Log.e(TAG, "DeleteAllPostsToDB");
        roomDataBase.oper().Delete();
    }
}