package com.example.engahmedatef.ahmed_bahaatask_1.ui.main_screen;

import android.content.Context;

import com.example.engahmedatef.ahmed_bahaatask_1.callback.OnDataLisener;
import com.example.engahmedatef.ahmed_bahaatask_1.data.local.PostModel_Room;
import com.example.engahmedatef.ahmed_bahaatask_1.data.local.Posts;
import com.example.engahmedatef.ahmed_bahaatask_1.data.remote.ApiModel;
import com.example.engahmedatef.ahmed_bahaatask_1.data_base.sqlite.Database_Connection;
import com.example.engahmedatef.ahmed_bahaatask_1.repository.RepositoryImp;

import java.util.List;

import static com.example.engahmedatef.ahmed_bahaatask_1.ui.main_screen.MainActivity.roomDataBase;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private ApiModel apiModel;
    private Database_Connection databaseConnection;
    public Posts posts_1;
    Context context;
    private RepositoryImp repositoryImp;

    public MainPresenter(Context context, MainContract.View view) {
        this.view = view;
        apiModel = new ApiModel();
        databaseConnection = new Database_Connection(context);
        this.context = context;
        posts_1 = new Posts(context);
        repositoryImp = new RepositoryImp();
    }
    public void getDataMainPresenter(String type) {
        apiModel.getPosts(type, new OnDataLisener() {
            @Override
            public void onSucess(List<Posts> postsList) {

                repositoryImp.DeleteAllPosts();

                for (int i = 0; i < postsList.size(); i++) {
                    //SingleTon
                    PostModel_Room postModel_room = PostModel_Room.getInstance(postsList.get(i).getUserId(), postsList.get(i).getUserId(), postsList.get(i).getTitle(), postsList.get(i).getBody());

                    postModel_room.setId(postsList.get(i).getId());
                    postModel_room.setUserId(postsList.get(i).getUserId());
                    postModel_room.setTitle(postsList.get(i).getTitle());
                    postModel_room.setBody(postsList.get(i).getBody());

                    repositoryImp.add(postModel_room);
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