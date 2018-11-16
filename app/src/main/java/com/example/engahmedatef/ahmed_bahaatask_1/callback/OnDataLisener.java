package com.example.engahmedatef.ahmed_bahaatask_1.callback;

import com.example.engahmedatef.ahmed_bahaatask_1.data.local.Posts;

import java.util.List;

public interface OnDataLisener {
    void onSucess(List<Posts> posts);
    void onError(String errorMsg);
}
