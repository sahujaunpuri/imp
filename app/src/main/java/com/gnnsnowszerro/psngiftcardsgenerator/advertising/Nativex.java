package com.gnnsnowszerro.psngiftcardsgenerator.advertising;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.nativex.monetization.MonetizationManager;
import com.nativex.monetization.business.reward.Reward;
import com.nativex.monetization.communication.RedeemRewardData;
import com.nativex.monetization.enums.AdEvent;
import com.nativex.monetization.enums.NativeXAdPlacement;
import com.nativex.monetization.listeners.OnAdEventV2;
import com.nativex.monetization.listeners.RewardListener;
import com.nativex.monetization.listeners.SessionListener;
import com.nativex.monetization.mraid.AdInfo;

/**
 * Created by mykola on 18.06.17.
 */

public class Nativex extends Advertising {
    public static final String TAG = "Nativex";

    public static final String AppId = "120243";
    private Activity activity;


    public Nativex(Context context, Activity activity) {
        super(context);
        this.activity = activity;
    }

    @Override
    public void initAdv() {
        Log.d(TAG, "initAdv");

        MonetizationManager.createSession(context, AppId, sessionListener);

        MonetizationManager.setRewardListener(rewardListener);

    }

    @Override
    public void finalizeAdv() {

    }

    @Override
    public void showAdv() {
        Log.d(TAG, "showAdv");
        if (MonetizationManager.isAdReady(NativeXAdPlacement.Main_Menu_Screen)) {
            MonetizationManager.showReadyAd(activity, NativeXAdPlacement.Main_Menu_Screen, onAdEventListener);
        }

    }

    private SessionListener sessionListener = new SessionListener() {
        @Override
        public void createSessionCompleted(boolean success, boolean isOfferWallEnabled, String sessionId) {
            if (success) {
                // a session with our servers was established successfully.
                // the app is now ready to show ads.
                Log.d(TAG, "Wahoo! Now I'm ready to show an ad.");
                MonetizationManager.fetchAd(activity, NativeXAdPlacement.Main_Menu_Screen, onAdEventListener);

                MonetizationManager.showReadyAd(activity, NativeXAdPlacement.Main_Menu_Screen, onAdEventListener);

            } else {
                // establishing a session with our servers failed;
                // the app will be unable to show ads until a session is established
                Log.d(TAG, "Oh no! Something isn't set up correctly - re-read the documentation or ask customer support for some help - https://selfservice.nativex.com/Help");
            }
        }
    };

    private RewardListener rewardListener = new RewardListener() {
        @Override
        public void onRedeem(RedeemRewardData data) {
            // take possession of the balances returned here
            int totalRewardAmount = 0;
            for (Reward reward : data.getRewards()) {
                Log.d(TAG, "Reward: rewardName:" + reward.getRewardName()
                        + " rewardId:" + reward.getRewardId()
                        + " amount:" + Double.toString(reward.getAmount()));
                // add the reward amount to the total
                totalRewardAmount += reward.getAmount();
            }
            addCoins(totalRewardAmount);
            sendUpdate();
        }
    };

    private OnAdEventV2 onAdEventListener = new OnAdEventV2() {
        @Override
        public void onEvent(AdEvent event, AdInfo adInfo, String message) {
            Log.d(TAG, "Placement: " + adInfo.getPlacement());
            switch (event) {
                case ALREADY_FETCHED:
                    Log.d(TAG, "ALREADY_FETCHED");
                    // fetchAd() is called with an Ad Name and there is already a fetched ad with the same name ready to be shown.
                    break;
                case ALREADY_SHOWN:
                    Log.d(TAG, "ALREADY_SHOWN");
                    // showAd() is called with an Ad Name and there is an ad already being shown with the same name at this moment.
                    break;
                case BEFORE_DISPLAY:
                    Log.d(TAG, "BEFORE_DISPLAY");
                    // Just before the Ad is displayed on the screen.
                    break;
                case DISMISSED:
                    Log.d(TAG, "DISMISSED");
                    // The ad is dismissed by the user or by the application.
                    break;
                case DISPLAYED:
                    Log.d(TAG, "DISPLAYED");
                    // The ad is shown on the screen. For fetched ads this event will fire when the showAd() method is called.
                    break;
                case DOWNLOADING:
                    Log.d(TAG, "DOWNLOADING");
                    // fetchAd() is called with an Ad Name and there is an ad already being fetched with the same name at this moment.
                    break;
                case ERROR:
                    Log.d(TAG, "ERROR:" + message);
                      showMessage(message);
                    // An error has occurred and the ad is going to be closed.
                    // More information about the error is passed in the "message" parameter.
                    break;
                case EXPIRED:
                    Log.d(TAG, "EXPIRED");
                    // A fetched ad expires. All fetched ads will expire after a certain time period if not shown.
                    break;
                case FETCHED:
                    Log.d(TAG, "FETCHED");
                    // The ad is ready to be shown. For fetched ads this method means that the ad is fetched successfully.
                    // You may want to initially put the showReadyAd() call here when you're doing your initial testing,
                    // but for production you should move it to a more appropriate place, as described in the Show an Ad section.
                    break;
                case NO_AD:
                    Log.d(TAG, "NO_AD: " + message);
                    showMessage(message);
                    // The device contacts the server, but there is no ad ready to be shown at this time.
                    break;
                case USER_NAVIGATES_OUT_OF_APP:
                    Log.d(TAG, "USER_NAVIGATES_OUT_OF_APP");
                    // The user clicks on a link or a button in the ad and is going to navigate out of the app
                    // to the Google Play or a browser applications.
                    break;
                case IMPRESSION_CONFIRMED:
                    Log.d(TAG, "IMPRESSION_CONFIRMED");
                    // ad has its impression event fired
                    break;
                case AD_CONVERTED:
                    Log.d(TAG, "AD_CONVERTED");
                    // rewarded video ad has converted, and rewards will be given
                    break;
                default:
                    break;
            }
        }
    };

}
