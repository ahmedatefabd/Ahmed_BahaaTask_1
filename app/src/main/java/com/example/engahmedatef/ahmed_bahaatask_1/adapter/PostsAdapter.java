package com.example.engahmedatef.ahmed_bahaatask_1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.engahmedatef.ahmed_bahaatask_1.R;
import com.example.engahmedatef.ahmed_bahaatask_1.data.local.Posts;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsHolder> {

    private Context context;
    private List<Posts> postsList;

    public PostsAdapter(Context context, List<Posts> postsList) {
        this.context = context;
        this.postsList = postsList;
    }

    private static PostsAdapter instance ;

    //Singleton-->PostsAdapter
    public static PostsAdapter getInstance (Context context, List<Posts> postsList){
        if (instance == null) {
            synchronized (Posts.class) {
                if (instance == null) {
                    System.out.println("getInstance(): First time getInstance was invoked!");
                    instance = new PostsAdapter(context, postsList);
                }
            }
        }
        return instance;
    }

    @Override
    public PostsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        PostsHolder holder = new PostsHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(PostsHolder holder, int position) {

        final Posts posts = postsList.get(position);

        holder.id.setText("Id   =           " + posts.getId());
        holder.title.setText("Title   =           " + posts.getTitle());
        holder.body.setText("Body   =           " + posts.getTitle());

    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public class PostsHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.id)
        TextView id;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.body)
        TextView body;
        @BindView(R.id.root)
        LinearLayout root;

        public PostsHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
