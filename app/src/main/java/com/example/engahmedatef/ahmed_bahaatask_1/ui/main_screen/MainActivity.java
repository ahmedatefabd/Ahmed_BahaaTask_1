package com.example.engahmedatef.ahmed_bahaatask_1.ui.main_screen;

import android.database.Cursor;
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
//    private MainPresenter presenter2 ;
    private PostsAdapter adapter ;
//    public static List<PostsModel_Room> posts_;
    public static List<Posts> postsList;
//    public static RoomDatabase roomDatabase ;
//    public static PostDAO postDAO ;
//    public static PostTask postTask ;

    CheckInternetConnection connection ;

    private static DB_Helper db_helper ;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MainPresenter( getApplicationContext(), this );

//        presenter.getDataMainPresenter(Constant.Api.BASE_URL);

//        presenter2 = new MainPresenter(this);

        postsList = new ArrayList<>();

        db_helper = new DB_Helper(this);

        connection = new CheckInternetConnection(this) ;

        boolean isConnected = connection.IsConnectingtoInternet();

        if (isConnected) {

//            presenter.getDataMainPresenter(Constant.Api.BASE_URL);

            LoadingData();

        } else {

            LoadDataOffline();
        }

//        CheckNetwork();







//        presenter.getDataMainPresenter(Constant.Api.BASE_URL);

//        roomDatabase = Room.databaseBuilder(getApplicationContext(), PostDataBase.class, "postsdb").allowMainThreadQueries().build();
//
//        postDAO = PostDataBase.getInstance(this).postDao();
//
//        postTask = new PostTask(postDAO, new OnDataLisener() {
//            @Override
//            public void onSucess(List<Posts> postsList) {
//
//
//                postsList.addAll(postsList);
//                recycler(postsList);
//                postDAO.deletePost();
//                for (int i = 0; i < postsList.size(); i++) {
//
//                    //SingleTon
//                    PostsModel_Room postModel_room = PostsModel_Room.getInstance(postsList.get(i).getUserId(), postsList.get(i).getTitle(String.valueOf(1)), postsList.get(i).getBody(String.valueOf(2)));
//                    postModel_room.setId(postsList.get(i).getId(0));
//                    postModel_room.setTitle(postsList.get(i).getTitle(String.valueOf(1)));
//                    postModel_room.setBody(postsList.get(i).getBody(String.valueOf(2)));
//                    postDAO.insertPost(posts_);
//                }
//            }
//
//            @Override
//            public void onError(String errorMsg) {
//
////                LoadDataOfflineRoom();
//            }
//
//            @Override
//            public void addPosts(List<PostsModel_Room> posts) {
//
//            }
//        });

    }

//    private void CheckNetwork() {
//
//        boolean isConnected = connection.IsConnectingtoInternet();
//
//        if (isConnected) {
//
//            LoadingData();
//
//        } else {
//
//            LoadDataOffline();
//        }
//    }

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

//        Cursor cursor = db_helper.getAlldata();
//
//            postsList = new ArrayList<>();
//
//            while (cursor.moveToNext()) {
//                int id = cursor.getInt(0);
//                String title = cursor.getString(1);
//                String body = cursor.getString(2);
//
//                Posts posts = new Posts( id, title, body, getApplicationContext());
//
//                postsList.add(posts);


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

//    public void LoadDataOfflineRoom() {
//        posts_ = postDAO.getAllPosts();
//        recyclerView.setAdapter(PostsAdapter_Offline_Room.getInstance(getApplicationContext(), posts_));
//
//    }

}
