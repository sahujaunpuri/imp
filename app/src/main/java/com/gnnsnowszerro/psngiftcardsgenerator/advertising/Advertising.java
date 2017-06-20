package com.gnnsnowszerro.psngiftcardsgenerator.advertising;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.gnnsnowszerro.psngiftcardsgenerator.helpers.PrefenceHelper;

import static com.gnnsnowszerro.psngiftcardsgenerator.fragments.MainFragment.ACTION_UPDATE;

/**
 * Created by mykola on 18.06.17.
 */

public abstract class Advertising {
    private PrefenceHelper helper;
    protected Context context;


    public abstract void initAdv();

    public abstract void finalizeAdv();

    public abstract void showAdv();

    public Advertising(Context context){
        this.context = context;
        helper = PrefenceHelper.getInstance(context);
    }

    public void sendUpdate(){
        this.context.sendBroadcast(new Intent(ACTION_UPDATE));
    }
    public void showMessage(String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }

    public void addCoins(int coints){
        helper.saveCoins((coints) + helper.loadCoins());
    }
}
