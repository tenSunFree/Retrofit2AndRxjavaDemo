package com.example.administrator.retrofit2andrxjavademo.Retrofit;

import com.example.administrator.retrofit2andrxjavademo.Model.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IMyAPI {
    /**
     * Observable物件, 用來發射資料流程然後終止資料流程
     * 添加想要取得資料的末段網址, "posts"
     * List<Post> 用來儲存該網址取得的每一筆的資料
     */
    @GET("posts")
    Observable<List<Post>> getPosts();
}
