package com.example.abrivard1.loginactivity;

import java.io.Serializable;
import java.util.List;

public class District implements Serializable{


    public int id;
    public String name;
    public String description;
    public int imageResourceId;
    //List<Store> stores;
    //List<Deposite> deposites;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public District(int id, String name, String description, int imageResourceId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
