package com.gnnsnowszerro.psngiftcardsgenerator.advertising;

import android.content.Context;

import com.gnnsnowszerro.psngiftcardsgenerator.helpers.PrefenceHelper;

/**
 * Created by mykola on 18.06.17.
 */

public abstract class Advertising {
    private PrefenceHelper helper;

    public abstract void initAdv();

    public abstract void finalizeAdv();

    public abstract void showAdv();

    public Advertising(Context context){
        helper = PrefenceHelper.getInstance(context);
    }

    public void addCoins(int coints){
        helper.saveCoins((coints) + helper.loadCoins());
    }
}
