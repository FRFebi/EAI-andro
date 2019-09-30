package com.example.belajarapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.LayoutManager layoutManager;
    private adapter adapter;
    private RecyclerView rv_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_data = findViewById(R.id.data_lagu);

        layoutManager = new LinearLayoutManager(getApplicationContext());
        setDataFromAPI();
    }

    private void setDataFromAPI() {
        interfaceAPI interfaceAPI = serviceAPI.getAPIdata().create(interfaceAPI.class);
        Call<responseAPI> call = interfaceAPI.getMusicData();
        call.enqueue(new Callback<responseAPI>() {
            @Override
            public void onResponse(Call<responseAPI> call, Response<responseAPI> response) {
                ArrayList<dataAPI> dataAPIArrayList = response.body().getResults();

                adapter = new adapter(dataAPIArrayList, getApplicationContext());

                rv_data.setLayoutManager(layoutManager);
                rv_data.setHasFixedSize(true);
                rv_data.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<responseAPI> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Network Error",Toast.LENGTH_LONG).show();
            }
        });
    }
}
