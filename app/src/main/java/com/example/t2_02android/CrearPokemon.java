package com.example.t2_02android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.t2_02android.entities.Pokemon;
import com.example.t2_02android.services.servicesWeb;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CrearPokemon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_pokemon);

        Button btn = findViewById(R.id.crearBtn);
        EditText etname=findViewById(R.id.edName);
        EditText etnumber=findViewById(R.id.etNumber);
        Spinner sp = findViewById(R.id.spinner);
        EditText region= findViewById(R.id.etReion);
//
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//          public void onClick(View view) {
////                Retrofit retrofit = new  Retrofit.Builder()
////                        .baseUrl("https://6284e8f8a48bd3c40b77c373.mockapi.io/api/v1/")
////                        .addConverterFactory(GsonConverterFactory.create())
////                        .build();
////
////                servicesWeb services = retrofit.create(servicesWeb.class);
//
//                //Pokemon pokemon = new Pokemon();
//
//
//                //pokemon.name=String.valueOf(etname.getText());
//               // pokemon.number=toString(etnumber.getText());
//                //pokemon.tipo=String.valueOf(s.getText());
//                //pokemon.region=String.valueOf(region.getText());
//
//
//               // services.create(pokemon);
//
////                Call<Pokemon> call = services.create(pokemon);
////
////               call.enqueue(new Callback<Pokemon>() {
////                    @Override
////                    public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
////
////                    }
////
////                    @Override
////                    public void onFailure(Call<Pokemon> call, Throwable t) {
////
////                    }
////             });
//
//
//
//            }
//        });




    }
}