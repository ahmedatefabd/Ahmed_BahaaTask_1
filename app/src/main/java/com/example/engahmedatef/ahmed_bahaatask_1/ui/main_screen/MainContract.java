package com.example.engahmedatef.ahmed_bahaatask_1.ui.main_screen;

import com.example.engahmedatef.ahmed_bahaatask_1.data.local.PostModel_Room;
import com.example.engahmedatef.ahmed_bahaatask_1.data.local.Posts;

import java.util.List;

public interface MainContract<P> {

    interface Presenter {

        void detachView();
    }
    interface View {

        void displayError(String msg);
        void displayData(List<Posts> posts);
        void recycler(List<Posts> posts_List);
        void recyclerOfflineRoom(List<PostModel_Room> postModelRooms);
        void LoadDataOfflineRoom();
        void LoadDataOfflineSql();
        void LoadingData();
    }
}
