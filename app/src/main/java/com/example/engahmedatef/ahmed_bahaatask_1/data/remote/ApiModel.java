package com.example.engahmedatef.ahmed_bahaatask_1.data.remote;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.example.engahmedatef.ahmed_bahaatask_1.callback.OnDataLisener;
import com.example.engahmedatef.ahmed_bahaatask_1.data.local.Posts;
import com.example.engahmedatef.ahmed_bahaatask_1.ui.main_screen.MainActivity;

import java.util.List;

public class ApiModel {

    public void getPosts(String type, final OnDataLisener listener){

        AndroidNetworking.get(type)
                .build()
                .getAsObjectList(Posts.class, new ParsedRequestListener<List<Posts>>() {

                    @Override
                    public void onResponse(List<Posts> response) {
//                        for (int i = 0; i < response.size(); i++) {
//                            // Insert in DataBase
////                    posts_1 = new Posts();
//
//                            Integer id = response.get(i).getId();
//                            String title = response.get(i).getTitle();
//                            String body = response.get(i).getBody();
//
//                           MainActivity.databaseConnection.insertPost(id, title, body);
//                    }
                        listener.onSucess(response);
                    }

                    @Override
                    public void onError(ANError anError) {

                        listener.onError(anError.getErrorDetail());
                    }
                });
    }
}
