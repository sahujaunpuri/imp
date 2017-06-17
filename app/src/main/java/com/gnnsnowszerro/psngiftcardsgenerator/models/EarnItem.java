package com.gnnsnowszerro.psngiftcardsgenerator.models;

/**
 * Created by mykola on 17.06.17.
 */

public class EarnItem {
    private String title;
    private int icon;

    public String getTitle() {
        return title;
    }

    public int getIcon() {
        return icon;
    }

    public EarnItem(String title, int icon) {

        this.title = title;
        this.icon = icon;
    }
}
