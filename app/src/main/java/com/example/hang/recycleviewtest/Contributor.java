package com.example.hang.recycleviewtest;

import android.support.annotation.DrawableRes;

public class Contributor {

    private String name;
    private String description;
    private @DrawableRes
    int profileImage;


    public Contributor(String name, String description, @DrawableRes int profileImage) {
        this.name = name;
        this.description = description;
        this.profileImage = profileImage;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getProfileImage() {
        return profileImage;
    }
}
