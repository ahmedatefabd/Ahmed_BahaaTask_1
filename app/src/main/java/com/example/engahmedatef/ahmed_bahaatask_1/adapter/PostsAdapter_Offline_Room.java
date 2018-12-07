package com.example.engahmedatef.ahmed_bahaatask_1.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.engahmedatef.ahmed_bahaatask_1.R;
import com.example.engahmedatef.ahmed_bahaatask_1.data.local.PostModel_Room;
import com.example.engahmedatef.ahmed_bahaatask_1.data.local.Posts;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PostsAdapter_Offline_Room extends RecyclerView.Adapter<PostsAdapter_Offline_Room.Holder> {


    private Context context;
    private List<PostModel_Room> posts;
    private int row_index = 0;


    public PostsAdapter_Offline_Room(Context context, List<PostModel_Room> posts) {
        this.context = context;
        this.posts = posts;
    }


    private static PostsAdapter_Offline_Room instance;

    public static PostsAdapter_Offline_Room getInstance(Context context, List<PostModel_Room> posts) {
        if (instance == null) {
            synchronized (Posts.class) {
                if (instance == null) {
                    System.out.println("getInstance(): First time getInstance was invoked!");
                    instance = new PostsAdapter_Offline_Room(context, posts);
                }
            }
        }

        return instance;
    }

    @NonNull
    public PostsAdapter_Offline_Room.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, null);
        PostsAdapter_Offline_Room.Holder Holder = new PostsAdapter_Offline_Room.Holder(item);
        return Holder;
    }

    @NonNull
    public void onBindViewHolder(final PostsAdapter_Offline_Room.Holder Holder, final int position) {
        PostModel_Room postModelRoom = posts.get(position);

        Holder.id.setText("Id   =           " + postModelRoom.getId());
        Holder.title.setText("Title   =           " + postModelRoom.getTitle());
        Holder.body.setText("Body   =           " + postModelRoom.getTitle());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.id)
        TextView id;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.body)
        TextView body;
        @BindView(R.id.root)
        LinearLayout root;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
