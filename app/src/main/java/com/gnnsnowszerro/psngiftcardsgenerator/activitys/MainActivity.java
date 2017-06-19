package com.gnnsnowszerro.psngiftcardsgenerator.activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.gnnsnowszerro.psngiftcardsgenerator.fragments.MainFragment;
import com.gnnsnowszerro.psngiftcardsgenerator.services.ShowNotification;

public class MainActivity extends ActivitySimple{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ShowNotification.setServiceAlarm(this,true);
    }

    @Override
    public Fragment setFragment() {
        return MainFragment.newInstance();
    }


}
