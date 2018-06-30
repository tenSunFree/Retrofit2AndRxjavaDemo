package com.example.administrator.retrofit2andrxjavademo.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.retrofit2andrxjavademo.R;

public class PostViewHolder extends RecyclerView.ViewHolder {

    TextView titleTextView, contentTextView, authorTextView;
    RelativeLayout rootRelativeLayout;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);
        titleTextView = itemView.findViewById(R.id.titleTextView);
        contentTextView = itemView.findViewById(R.id.contentTextView);
        authorTextView = itemView.findViewById(R.id.authorTextView);
        rootRelativeLayout = itemView.findViewById(R.id.rootRelativeLayout);
    }
}
