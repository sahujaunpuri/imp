package com.gnnsnowszerro.psngiftcardsgenerator.helpers;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;


public class PrefenceHelper {

    public static PrefenceHelper helper;
    private SharedPreferences sPref;

    public static final String PREFERENCE = "preference";

    public static final String SAVED_COINS = "coins";

    private PrefenceHelper(Context context) {
        sPref = context.getSharedPreferences(PREFERENCE, MODE_PRIVATE);
    }

    public static PrefenceHelper getInstance(Context c) {
        if (helper == null)
            helper = new PrefenceHelper(c);
        return helper;
    }

    public void saveCoins(int coins) {
        SharedPreferences.Editor ed = sPref.edit();
        ed.putInt(SAVED_COINS, coins);
        ed.commit();
    }


    public int loadCoins() {
        return sPref.getInt(SAVED_COINS, 0);
    }
}
