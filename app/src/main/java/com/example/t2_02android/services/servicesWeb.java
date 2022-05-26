package com.example.t2_02android.services;

import com.example.t2_02android.entities.Pokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface servicesWeb {
    @GET("pokemons/")
    Call<List<Pokemon>> getContacts();

    @GET("pokemons/{id}")
    Call<Pokemon> findContact(@Path("id") int id);

    @POST("pokemons")
    Call<Pokemon> create(@Body Pokemon pokemon);


}
