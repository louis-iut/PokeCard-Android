package com.example.louis.pokecard_android.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by louis on 18/10/2017.
 */

public class PokemonRemoteEntity {

    @SerializedName("id")
    private int id;
    @SerializedName("imageURL")
    private String image;
    @SerializedName("name")
    private String name;

    public PokemonRemoteEntity(int id, String image, String name) {

        this.id = id;
        this.image = image;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}
