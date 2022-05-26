package com.example.t2_02android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.t2_02android.adapters.pokemonAdapter;
import com.example.t2_02android.entities.Pokemon;
import com.example.t2_02android.services.servicesWeb;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class listarPokemos extends AppCompatActivity {
    public RecyclerView rv;
    List<Pokemon> pokemons= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_pokemos);

        Retrofit retrofit = new  Retrofit.Builder()
                .baseUrl("https://6284e8f8a48bd3c40b77c373.mockapi.io/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        servicesWeb services = retrofit.create(servicesWeb.class);
        Call<List<Pokemon>> call=services.getContacts();

        call.enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {
                if (!response.isSuccessful()){
                    Log.e("asd1234", "error");
                }else{
                    Log.i("asdasd12312", new Gson().toJson(response.body()));
                    Log.i("asd32", "Respuesta correcta");

                    pokemons=response.body();

                    pokemonAdapter adapter=new pokemonAdapter(pokemons);


                    rv= findViewById(R.id.rvPokemon);
                    rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rv.setHasFixedSize(true);
                    rv.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable t) {
                Log.e("asd1234", "no hay conexion");
            }
        });

    }
}