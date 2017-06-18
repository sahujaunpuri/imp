package com.gnnsnowszerro.psngiftcardsgenerator.models;

/**
 * Created by mykola on 17.06.17.
 */

public class EarnItem {


    private int id;
    private String title;
    private int icon;

    public String getTitle() {
        return title;
    }

    public int getIcon() {
        return icon;
    }

    public int getId() {
        return id;
    }

    public EarnItem(int id, String title, int icon) {

        this.id = id;
        this.title = title;
        this.icon = icon;
    }

}
