package com.gnnsnowszerro.psngiftcardsgenerator.activitys;

import android.support.v4.app.Fragment;

import com.gnnsnowszerro.psngiftcardsgenerator.fragments.MainFragment;

public class MainActivity extends ActivitySimple{


    @Override
    public Fragment setFragment() {
        return MainFragment.newInstance();
    }

}
