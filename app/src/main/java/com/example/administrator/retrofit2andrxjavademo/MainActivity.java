package com.example.administrator.retrofit2andrxjavademo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.retrofit2andrxjavademo.Adapter.PostAdapter;
import com.example.administrator.retrofit2andrxjavademo.Model.Post;
import com.example.administrator.retrofit2andrxjavademo.Retrofit.IMyAPI;
import com.example.administrator.retrofit2andrxjavademo.Retrofit.RetrofitClient;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    IMyAPI iMyAPI;
    RecyclerView postsRecyclerView;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Init API */
        Retrofit retrofit = RetrofitClient.getInstance();
        iMyAPI = retrofit.create(IMyAPI.class);

        /** View */
        postsRecyclerView = findViewById(R.id.postsRecyclerView);
        postsRecyclerView.setHasFixedSize(true);
        postsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        fetchData();
    }

    /**
     * 向伺服器取得資料
     */
    private void fetchData() {
        compositeDisposable.add(
                iMyAPI.getPosts()
                        .subscribeOn(Schedulers.io())                                                // 指定在io线程中发起, 多数情况下io()比newThread()更有效率
                        .observeOn(AndroidSchedulers.mainThread())                                   // 指定Subscriber的回调发生在主线程
                        .subscribe(new Consumer<List<Post>>() {
                            @Override
                            public void accept(List<Post> posts) throws Exception {
                                displayData(posts);
                            }
                        })
        );
    }

    /**
     * 將取得的資料 放進RecyclerView顯示出來
     */
    private void displayData(List<Post> posts) {
        PostAdapter postAdapter = new PostAdapter(this, posts);
        postsRecyclerView.setAdapter(postAdapter);
    }

    @Override
    protected void onStop() {
        compositeDisposable.clear();                                                                // 快速解除所有添加的Disposable类
        super.onStop();
    }
}
