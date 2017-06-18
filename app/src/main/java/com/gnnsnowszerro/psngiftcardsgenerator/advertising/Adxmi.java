package com.gnnsnowszerro.psngiftcardsgenerator.advertising;

import android.content.Context;
import android.util.Log;

import net.adxmi.android.AdManager;
import net.adxmi.android.os.EarnPointsOrderInfo;
import net.adxmi.android.os.EarnPointsOrderList;
import net.adxmi.android.os.OffersManager;
import net.adxmi.android.os.PointsEarnNotify;
import net.adxmi.android.os.PointsManager;

/**
 * Created by mykola on 18.06.17.
 */

public class Adxmi extends Advertising implements
        PointsEarnNotify {
    public static final String TAG = "Adxmi";
    private final static String mAppId = "01bc87913a968e80";

    private final static String mAppSecret = "19edf67159c7e389";

    private Context context;

    public Adxmi(Context context) {
        super(context);

        this.context = context;
    }


    @Override
    public void initAdv() {
        AdManager.getInstance(context).init(mAppId, mAppSecret);
        OffersManager.getInstance(context).onAppLaunch();

        PointsManager.getInstance(context).registerPointsEarnNotify(this);

    }

    @Override
    public void finalizeAdv() {


        PointsManager.getInstance(context).unRegisterPointsEarnNotify(this);

        OffersManager.getInstance(context).onAppExit();

    }

    @Override
    public void showAdv() {
        OffersManager.getInstance(context).showOffersWall();
        Log.d(TAG, "show");
    }


    @Override
    public void onPointEarn(Context context, EarnPointsOrderList list) {
        int add = 0;

        for (int i = 0; i < list.size(); ++i) {
            EarnPointsOrderInfo info = list.get(i);
            add += info.getPoints();
        }

        addCoins(add);

    }


}
