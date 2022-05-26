package com.example.t2_02android.adapters;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.t2_02android.R;
import com.example.t2_02android.entities.Pokemon;
import com.example.t2_02android.minListaPokemon;
import com.example.t2_02android.services.servicesWeb;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class pokemonAdapter extends RecyclerView.Adapter<pokemonAdapter.pokemonViewHolder> {
    List<Pokemon> pokemons;

    public pokemonAdapter(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @NonNull
    @Override
    public pokemonAdapter.pokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon,parent,false);
        pokemonAdapter.pokemonViewHolder vh= new pokemonAdapter.pokemonViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull pokemonAdapter.pokemonViewHolder holder, int position) {
        View vw=holder.itemView;

        Pokemon pokemon = pokemons.get(position);
        TextView itemCodigo=holder.itemView.findViewById(R.id.tvCodigo);
        TextView itemName=holder.itemView.findViewById(R.id.tvNombre);
        ImageView itemImg=holder.itemView.findViewById(R.id.avatar);


        itemCodigo.setText(Integer.toString(pokemon.number));
        itemName.setText(pokemon.name);

        String url="https://i.ytimg.com/vi/1roy4o4tqQM/maxresdefault.jpg";
        Picasso.get().load(url).into(itemImg);

        vw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofit = new  Retrofit.Builder()
                        .baseUrl("https://6284e8f8a48bd3c40b77c373.mockapi.io/api/v1/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                servicesWeb services = retrofit.create(servicesWeb.class);
                Call<Pokemon> call=services.findContact(pokemon.id);



                call.enqueue(new Callback<Pokemon>() {
                    @Override
                    public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                        if (!response.isSuccessful()){
                            Log.e("asd1234", "error");
                        }else {

                            Log.i("asdasd12312", new Gson().toJson(response.body()));
                            Log.i("asd32", "Respuesta correcta por id");

                            Intent intent= new Intent(vw.getContext(), minListaPokemon.class);


                            Log.i("asd32", "Respuesta correcta por id------------ ");
                            intent.putExtra("name",pokemon.name);
                            intent.putExtra("number",pokemon.number);
                            intent.putExtra("number",pokemon.region);
                            intent.putExtra("number",pokemon.tipo);

                            vw.getContext().startActivity(intent);

                        }
                    }

                    @Override
                    public void onFailure(Call<Pokemon> call, Throwable t) {

                    }
                });
            }

        });
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    public class pokemonViewHolder extends RecyclerView.ViewHolder {
        public pokemonViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
