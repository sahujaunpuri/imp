package com.gnnsnowszerro.psngiftcardsgenerator.activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.gnnsnowszerro.psngiftcardsgenerator.R;
import com.gnnsnowszerro.psngiftcardsgenerator.advertising.AppNext;

public abstract class ActivitySimple extends AppCompatActivity {

    private AppNext appNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);


        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragment = setFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }

        appNext = new AppNext(this, findViewById(R.id.appnext_container));
        appNext.initAdv();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        appNext.finalizeAdv();
    }

    public abstract Fragment setFragment();


}
