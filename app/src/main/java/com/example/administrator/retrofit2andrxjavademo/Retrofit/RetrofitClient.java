package com.example.administrator.retrofit2andrxjavademo.Retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit ourInstance;

    public static Retrofit getInstance() {
        if (ourInstance == null) {
            ourInstance = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")                               // 请求地址
                    .addConverterFactory(GsonConverterFactory.create())                               // 如果你想接收json结果并解析成DAO, 你必须把GsonConverter作为一个独立的依赖添加进来, 然后使用addConverterFactory把它添加进来
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())                        // 通过RxJavaCallAdapterFactory为Retrofit添加RxJava支持, 针对rxjava2.x
                    .build();
        }
        return ourInstance;
    }

    private RetrofitClient() {
    }
}
