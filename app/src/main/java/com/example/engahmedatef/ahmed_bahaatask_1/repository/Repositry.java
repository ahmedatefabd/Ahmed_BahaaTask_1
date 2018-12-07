package com.example.engahmedatef.ahmed_bahaatask_1.repository;

import com.example.engahmedatef.ahmed_bahaatask_1.data.local.PostModel_Room;
import com.example.engahmedatef.ahmed_bahaatask_1.data.local.Posts;

public interface Repositry {

    interface RepoData_Api_DB{
        void getData();
    }

    interface RepoDB{

        void add(PostModel_Room postModel_room);
//        void add(Posts posts);
        void getAllPosts();
        void updateData(int id, String title, String body);
        void DeleteAllPosts();
    }
}
