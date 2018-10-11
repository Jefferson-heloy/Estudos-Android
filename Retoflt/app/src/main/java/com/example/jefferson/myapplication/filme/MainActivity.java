package com.example.jefferson.myapplication.filme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;


import com.example.jefferson.myapplication.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.list_item);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://192.168.0.52:5200")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        Filmes client = retrofit.create(Filmes.class);
        Call<List<Filme>> call = client.reposForuser("filme");
        call.enqueue(new Callback<List<Filme>>() {
            @Override
            public void onResponse(Call<List<Filme>> call, Response<List<Filme>> response) {
                List<Filme> repos = response.body();
                listView.setAdapter(new ListAdapter(MainActivity.this, -1, repos));
            }

            @Override
            public void onFailure(Call<List<Filme>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"error",Toast.LENGTH_SHORT).show();
            }
        });
    }
}