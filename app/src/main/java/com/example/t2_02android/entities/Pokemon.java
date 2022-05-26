package com.example.t2_02android.entities;

import android.text.Editable;

public class Pokemon {
    public int id;
    public int number;
    public String name;
    public String tipo;
    public String region;
    public int img;

    public Pokemon() {
    }

    public Pokemon(int id, int number, String name, String tipo, String region, int img) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.tipo = tipo;
        this.region = region;
        this.img=img;
    }
}
