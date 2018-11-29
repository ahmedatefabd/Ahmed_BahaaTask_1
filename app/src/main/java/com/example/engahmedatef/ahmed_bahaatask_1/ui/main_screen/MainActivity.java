package com.example.engahmedatef.ahmed_bahaatask_1.ui.main_screen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.engahmedatef.ahmed_bahaatask_1.R;
import com.example.engahmedatef.ahmed_bahaatask_1.adapter.PostsAdapter;
import com.example.engahmedatef.ahmed_bahaatask_1.data.local.Posts;
import com.example.engahmedatef.ahmed_bahaatask_1.data_base.sqlite.DB_Helper;
import com.example.engahmedatef.ahmed_bahaatask_1.util.CheckInternetConnection;
import com.example.engahmedatef.ahmed_bahaatask_1.util.Constant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainPresenter presenter ;
    private PostsAdapter adapter ;
    private static DB_Helper db_helper ;
    public static List<Posts> postsList;
    CheckInternetConnection connection ;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        postsList = new ArrayList<>();
        presenter = new MainPresenter( getApplicationContext(), this );
        db_helper = new DB_Helper(this);
        connection = new CheckInternetConnection(this) ;
        boolean isConnected = connection.IsConnectingtoInternet();
        if (isConnected) {
            LoadingData();
        } else {
            LoadDataOffline();
        }
 }
    private void LoadingData() {
        presenter.getDataMainPresenter(Constant.Api.BASE_URL);
    }
    @Override
    public void displayData(List<Posts> posts_List) {
        postsList.clear();
        postsList.addAll(posts_List);
        recycler(posts_List);
    }
    @Override
    public void displayError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        LoadDataOffline();
    }
    private void LoadDataOffline() {
        List<Posts> postsList1 = db_helper.getAllPosts();
                recycler(postsList1);
        }
    private void recycler(List<Posts> posts) {
        adapter = new PostsAdapter(MainActivity.this, posts);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(adapter);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
