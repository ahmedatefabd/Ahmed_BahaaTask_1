package com.example.engahmedatef.ahmed_bahaatask_1.ui.main_screen;

import android.content.Context;

import com.example.engahmedatef.ahmed_bahaatask_1.callback.OnDataLisener;
import com.example.engahmedatef.ahmed_bahaatask_1.data.local.Posts;
import com.example.engahmedatef.ahmed_bahaatask_1.data.remote.ApiModel;
import com.example.engahmedatef.ahmed_bahaatask_1.data_base.sqlite.DB_Helper;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
//    private MainContract.two two;
    private ApiModel apiModel;

    private DB_Helper db_helper ;

    public MainPresenter(Context context, MainContract.View view) {
        this.view = view;
        apiModel = new ApiModel();
        db_helper = new DB_Helper(context);
    }

//    public MainPresenter(MainContract.two two){
//        this.two = two ;
//        apiModel = new ApiModel();
//    }

    public void getDataMainPresenter(String type) {
        apiModel.getPosts(type, new OnDataLisener() {
            @Override
            public void onSucess(List<Posts> postsList) {

                db_helper.DeleteAllPosts();

                for (int i = 0; i < postsList.size(); i++) {

                    // Insert in DataBase

                    Posts posts = new Posts();

                    posts.setId(String.valueOf(postsList.get(i).getId()));
                    posts.setTitle(postsList.get(i).getTitle());
                    posts.setBody(postsList.get(i).getBody());

                    db_helper.insertPost(posts);

                }

                view.displayData(postsList);
            }

            @Override
            public void onError(String errorMsg) {

                view.displayError(errorMsg);
            }
        });
    }

    @Override
    public void detachView() {

    }
}
