package com.example.jefferson.myapplication.filme;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface Filmes {

    @GET("/api/filme/{user}")
    Call<List<Filme>> reposForuser(@Path("user") String user);
}
