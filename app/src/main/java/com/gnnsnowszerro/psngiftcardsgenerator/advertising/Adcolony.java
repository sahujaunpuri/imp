package com.gnnsnowszerro.psngiftcardsgenerator.advertising;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.AdColonyInterstitialListener;
import com.adcolony.sdk.AdColonyZone;

/**
 * Created by mykola on 18.06.17.
 */

public class Adcolony extends Advertising {
    public static final String TAG = "Adcolony";

    public static final String AppId = "appa567471ee29646b5b5";
    public static final String ZONE_ID = "vzac61b40e83e8436c9e";
    private Activity activity;

    public Adcolony(Context context, Activity activity) {
        super(context);
        this.activity = activity;
    }

    @Override
    public void initAdv() {
        AdColony.configure(activity, AppId, ZONE_ID);
        Log.d(TAG, "initAdv");

        _listener = new AdColonyInterstitialListener() {
            @Override
            public void onRequestFilled(AdColonyInterstitial ad) {
                _ad = ad;
                _ad.show();
                Log.d(TAG, "onRequestFilled");

            }

            @Override
            public void onClosed(AdColonyInterstitial ad) {
                super.onClosed(ad);
                addCoins(10);
                sendUpdate();
                Log.d(TAG, "onClosed");
            }

            @Override
            public void onRequestNotFilled(AdColonyZone zone) {
                super.onRequestNotFilled(zone);
                showMessage("No allow content");
                Log.d(TAG, "onRequestNotFilled");
            }

            @Override
            public void onOpened(AdColonyInterstitial ad) {
                super.onOpened(ad);
                Log.d(TAG, "onOpened");
            }

            @Override
            public void onIAPEvent(AdColonyInterstitial ad, String product_id, int engagement_type) {
                super.onIAPEvent(ad, product_id, engagement_type);
                Log.d(TAG, "onIAPEvent");
            }

            @Override
            public void onExpiring(AdColonyInterstitial ad) {
                super.onExpiring(ad);
                Log.d(TAG, "onExpiring");
            }

            @Override
            public void onLeftApplication(AdColonyInterstitial ad) {
                super.onLeftApplication(ad);
                Log.d(TAG, "onLeftApplication");
            }

            @Override
            public void onClicked(AdColonyInterstitial ad) {
                super.onClicked(ad);
                Log.d(TAG, "onClicked");
            }
        };
        AdColony.requestInterstitial(ZONE_ID, _listener, null);

    }

    @Override
    public void finalizeAdv() {

    }

    @Override
    public void showAdv() {
        Log.d(TAG, "showAdv");
        if (_ad != null) {
            _ad.show();
        }
    }

    AdColonyInterstitial _ad = null;
    AdColonyInterstitialListener _listener = null;


}
