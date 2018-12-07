package com.example.engahmedatef.ahmed_bahaatask_1.room_DB;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.engahmedatef.ahmed_bahaatask_1.data.local.PostModel_Room;

import java.util.List;

@Dao
public interface PostDAO {

    @SuppressWarnings("unchecked")
    @Insert
     void AddUser(PostModel_Room postModel_room);

    @SuppressWarnings("unchecked")
    @Query("DELETE FROM posts")
     void Delete();

    @SuppressWarnings("unchecked")
    @Query("select * from posts")
    List<PostModel_Room>  GetData();


    @SuppressWarnings("unchecked")
    @Delete
     void deletePost(PostModel_Room postModel_room);
}
