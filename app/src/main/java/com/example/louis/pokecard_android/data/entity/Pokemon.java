package com.example.louis.pokecard_android.data.entity;

import android.widget.ImageView;

/**
 * Created by louis on 18/10/2017.
 */

public class Pokemon {

    private int id;
    private String image;
    private String name;
    private String element;

    public Pokemon(int id, String image, String name, String element) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.element = element;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }
}
