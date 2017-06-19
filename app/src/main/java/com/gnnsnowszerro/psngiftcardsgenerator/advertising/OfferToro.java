package com.gnnsnowszerro.psngiftcardsgenerator.advertising;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.gnnsnowszerro.psngiftcardsgenerator.callbacks.UpdateListener;
import com.offertoro.sdk.OTOfferWallSettings;
import com.offertoro.sdk.interfaces.OfferWallListener;
import com.offertoro.sdk.sdk.OffersInit;


/**
 * Created by mykola on 18.06.17.
 */

public class OfferToro extends Advertising {
    public static final String SECRET_KEY = "e04ac7cb5cba11fbed15a53cab99e952"; //set your value
    public static final String APP_ID = "2632"; //set your value
    public static final String USER_ID = "4746"; //set your value

    public static final String TAG = "OfferToro";



    private Activity activity;


    private OffersInit offersInit;

    public OfferToro(Context context, UpdateListener updateListener,Activity activity) {
        super(context,updateListener);
        this.activity = activity;

    }


    @Override
    public void initAdv() {
        OTOfferWallSettings.getInstance().configInit(APP_ID,
                SECRET_KEY, USER_ID);
        offersInit = OffersInit.getInstance();

        offersInit.setOfferWallListener(new OfferWallListener() {
            @Override
            public void onOTOfferWallInitSuccess() {
                Log.d(TAG, "onOTOfferWallInitSuccess");
            }

            @Override
            public void onOTOfferWallInitFail(String s) {
                Log.d(TAG, "oonOTOfferWallInitFail. Error:" + s);
            }

            @Override
            public void onOTOfferWallOpened() {
                Log.d(TAG, "onOTOfferWallOpened");
            }

            @Override
            public void onOTOfferWallCredited(double v, double v1) {
                addCoins((int) v);
                Log.d(TAG, "onOTOfferWallCredited. v =  " + v + ", v1 = " + v1);
            }

            @Override
            public void onOTOfferWallClosed() {
                Log.d(TAG, "onOTOfferWallClosed");
            }
        });

        offersInit.getOTOfferWallCredits();


    }

    @Override
    public void finalizeAdv() {

    }

    @Override
    public void showAdv() {
        offersInit.showOfferWall(activity);
    }
}
