package com.example.json5_newsapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Trigger();
    }
    public void Trigger(){

        Retrofit Retro = new Retrofit.Builder().baseUrl("https://newsapi.org/").addConverterFactory(GsonConverterFactory.create()).build();
        Call<firstclass> obj = Retro.create(Myinterface.class).getData();
        obj.enqueue(new Callback<firstclass>() {
            @Override
            public void onResponse(Call<firstclass> call, Response<firstclass> response) {
                Baseadp adp= new Baseadp(getApplicationContext(),response.body().articles);//(context,data kismein hai)
                ListView list= findViewById(R.id.listview);
                list.setAdapter(adp);

            }

            @Override
            public void onFailure(Call<firstclass> call, Throwable t) {

            }
        });

    }
    interface Myinterface{


        @GET("/v2/everything?domains=wsj.com&apiKey=eec24193987c4ebdbf06eede78873e00")
        retrofit2.Call<firstclass> getData();

    }
}