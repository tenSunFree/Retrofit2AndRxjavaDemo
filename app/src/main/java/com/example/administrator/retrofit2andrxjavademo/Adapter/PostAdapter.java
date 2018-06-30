package com.example.administrator.retrofit2andrxjavademo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.retrofit2andrxjavademo.Model.Post;
import com.example.administrator.retrofit2andrxjavademo.R;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    Context context;
    List<Post> postList;

    public PostAdapter(Context context, List<Post> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.post_layout, viewGroup, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int i) {
        postViewHolder.titleTextView.setText(String.valueOf(postList.get(i).title));
        postViewHolder.contentTextView.setText(String.valueOf(postList.get(i).body));
        postViewHolder.authorTextView.setText(String.valueOf(postList.get(i).id));
        if (i==0) {
            postViewHolder.rootRelativeLayout.setBackgroundResource(R.drawable.layout_style2);
        } else if (i%2!=0) {
            postViewHolder.rootRelativeLayout.setBackgroundResource(R.drawable.layout_style);
        } else {
            postViewHolder.rootRelativeLayout.setBackgroundResource(R.drawable.layout_style2);
        }
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}
