package com.example.t2_02android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class minListaPokemon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_min_lista_pokemon);

        Intent intent=getIntent();

        String name=intent.getStringExtra("name");
        String number=intent.getStringExtra("number");
        String region=intent.getStringExtra("region");
        String tipo=intent.getStringExtra("tipo");

        TextView tvname=findViewById(R.id.textViewName);
        TextView tvmNumber=findViewById(R.id.textViewNumber);
        TextView tvmRegion=findViewById(R.id.textViewRegion);
        TextView tvTipo=findViewById(R.id.textViewRegion);

        tvname.setText(name);
        tvmNumber.setText(number);
        tvmRegion.setText(region);
        tvTipo.setText(tipo);
    }
}