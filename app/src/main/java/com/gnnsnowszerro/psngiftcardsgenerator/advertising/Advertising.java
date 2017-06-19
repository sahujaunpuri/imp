package com.gnnsnowszerro.psngiftcardsgenerator.advertising;

import android.content.Context;

import com.gnnsnowszerro.psngiftcardsgenerator.callbacks.UpdateListener;
import com.gnnsnowszerro.psngiftcardsgenerator.helpers.PrefenceHelper;

/**
 * Created by mykola on 18.06.17.
 */

public abstract class Advertising {
    private PrefenceHelper helper;
    protected Context context;
    protected UpdateListener updateListener;

    public abstract void initAdv();

    public abstract void finalizeAdv();

    public abstract void showAdv();

    public Advertising(Context context,UpdateListener updateListener){
        this.context = context;
        this.updateListener = updateListener;
        helper = PrefenceHelper.getInstance(context);
    }

    public void addCoins(int coints){
        helper.saveCoins((coints) + helper.loadCoins());
    }
}
