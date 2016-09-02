package com.von.voncat.module.contact.model;

import android.content.Intent;

/**
 * Created by Administrator on 2016/4/12 0012.
 */
public class ContactModel {

    private String name;
    private Intent intent;
    private String description;
    private String icon_img;

    public ContactModel() {
    }

    public ContactModel(String name, Intent intent, String description, String icon_img) {
        this.name = name;
        this.intent = intent;
        this.description = description;
        this.icon_img = icon_img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon_img() {
        return icon_img;
    }

    public void setIcon_img(String icon_img) {
        this.icon_img = icon_img;
    }
}


