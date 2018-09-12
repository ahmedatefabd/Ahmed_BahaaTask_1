package com.example.engahmedatef.ahmed_bahaatask_1.ui.main_screen;

import com.example.engahmedatef.ahmed_bahaatask_1.callback.OnDataLisener;
import com.example.engahmedatef.ahmed_bahaatask_1.data.local.Posts;
import com.example.engahmedatef.ahmed_bahaatask_1.data.remote.ApiModel;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private ApiModel apiModel;

    public MainPresenter(MainContract.View view) {
        this.view = view;
        apiModel = new ApiModel();
    }

    public void getDataMainPresenter(String type){
        apiModel.getPosts( type , new OnDataLisener() {
            @Override
            public void onSucess(List<Posts> postsList) {
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
        view = null ;
    }
}
