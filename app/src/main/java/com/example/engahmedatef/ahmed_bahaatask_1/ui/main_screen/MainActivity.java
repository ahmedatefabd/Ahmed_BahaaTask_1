package com.example.engahmedatef.ahmed_bahaatask_1.ui.main_screen;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.engahmedatef.ahmed_bahaatask_1.R;
import com.example.engahmedatef.ahmed_bahaatask_1.adapter.PostsAdapter;
import com.example.engahmedatef.ahmed_bahaatask_1.adapter.PostsAdapter_Offline_Room;
import com.example.engahmedatef.ahmed_bahaatask_1.data.local.PostModel_Room;
import com.example.engahmedatef.ahmed_bahaatask_1.data.local.Posts;
import com.example.engahmedatef.ahmed_bahaatask_1.data_base.sqlite.Database_Connection;
import com.example.engahmedatef.ahmed_bahaatask_1.data_base.sqlite.Database_Helper;
import com.example.engahmedatef.ahmed_bahaatask_1.repository.Factory;
import com.example.engahmedatef.ahmed_bahaatask_1.repository.Repositry;
import com.example.engahmedatef.ahmed_bahaatask_1.room_DB.RoomDataBase;
import com.example.engahmedatef.ahmed_bahaatask_1.util.CheckInternetConnection;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    public static MainPresenter presenter ;
    public static Database_Connection databaseConnection;
    public static List<Posts> postsList;
    public static List<PostModel_Room> posts_;
    CheckInternetConnection connection ;
    public static RoomDataBase roomDataBase;
    private Factory factory;

    private String Api = "api";
    private String DB = "db";
    private boolean isConnected;

   public static RecyclerView recyclerView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =findViewById(R.id.recyclerView);

        ButterKnife.bind(this);
        presenter = new MainPresenter( this, this );
        databaseConnection = new Database_Connection(this);
        connection = new CheckInternetConnection(this) ;
        factory = new Factory();

        roomDataBase = Room.databaseBuilder(getApplicationContext(), RoomDataBase.class, "postsdb").allowMainThreadQueries().build();

        postsList = new ArrayList<>();
        posts_ = new ArrayList<>();
        recyclerInit();

        isConnected = connection.IsConnectingtoInternet();
        if (isConnected) {
            LoadingData();
        } else {
            LoadDataOfflineRoom();
        }
 }

    private void recyclerInit() {
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    @Override
    public void LoadingData() {
        Repositry.RepoData_Api_DB repoDataApi = factory.getData(Api);
        repoDataApi.getData();
    }

    @Override
    public void displayData(List<Posts> posts_List) {
        postsList.clear();
        postsList.addAll(posts_List);
        recycler(posts_List);
    }

    @Override
    public void recycler(List<Posts> posts_List) {
        recyclerView.setAdapter(PostsAdapter.getInstance(MainActivity.this, posts_List));
    }

    @Override
    public void displayError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        LoadDataOfflineRoom();
    }

    @Override
    public void LoadDataOfflineRoom() {
        Repositry.RepoData_Api_DB repoDataOF = factory.getData(DB);
        repoDataOF.getData();
    }

    @Override
    public void LoadDataOfflineSql() {
    }

    @Override
    public void recyclerOfflineRoom(List<PostModel_Room> postModelRooms) {
        recyclerView.setAdapter(PostsAdapter_Offline_Room.getInstance(MainActivity.this, postModelRooms));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}