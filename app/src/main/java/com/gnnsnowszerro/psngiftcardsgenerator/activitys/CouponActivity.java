package com.gnnsnowszerro.psngiftcardsgenerator.activitys;

import android.support.v4.app.Fragment;

import com.gnnsnowszerro.psngiftcardsgenerator.fragments.CouponFragment;

import static com.gnnsnowszerro.psngiftcardsgenerator.fragments.CouponFragment.COUPON_POSITION;

public class CouponActivity extends ActivitySimple {


    @Override
    public Fragment setFragment() {
        return CouponFragment.newInstance(getIntent().getIntExtra(COUPON_POSITION, 0));
    }


}
