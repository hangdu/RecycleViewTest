package com.example.hang.recycleviewtest;

import android.support.annotation.DrawableRes;

import java.util.ArrayList;

public class Contributor {

    private String name;
    private String description;
    private @DrawableRes
    int profileImage;
    private ArrayList<Contact> contacts;
    private String email;


    public Contributor(String name, String description, @DrawableRes int profileImage) {
        this.name = name;
        this.description = description;
        this.profileImage = profileImage;
        contacts = new ArrayList<>();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    public void setName(String name) {
        this.name = name;
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

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void addSocial(String label, String url) {
        Contact c = new Contact(url, label);
        contacts.add(c);
    }
}
