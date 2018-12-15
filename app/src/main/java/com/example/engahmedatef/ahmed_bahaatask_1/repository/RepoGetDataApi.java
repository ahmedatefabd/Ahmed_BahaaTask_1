package com.example.engahmedatef.ahmed_bahaatask_1.repository;

import com.example.engahmedatef.ahmed_bahaatask_1.util.Constant;

import static com.example.engahmedatef.ahmed_bahaatask_1.ui.main_screen.MainActivity.presenter;


public class RepoGetDataApi implements Repositry.RepoData_Api_DB {
    // get data from Api
    @Override
    public void getData() {
        presenter.getDataMainPresenter(Constant.Api.BASE_URL);
    }
}
