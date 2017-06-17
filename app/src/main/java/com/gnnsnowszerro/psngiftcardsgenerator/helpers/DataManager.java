package com.gnnsnowszerro.psngiftcardsgenerator.helpers;

import com.gnnsnowszerro.psngiftcardsgenerator.R;
import com.gnnsnowszerro.psngiftcardsgenerator.models.Coupon;
import com.gnnsnowszerro.psngiftcardsgenerator.models.EarnItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mykola on 17.06.17.
 */
public class DataManager {
    private static DataManager ourInstance = new DataManager();
    private List<Coupon> coupons;
    private List<EarnItem> earnItems;

    public static DataManager getInstance() {
        if (ourInstance == null)
            ourInstance = new DataManager();
        return ourInstance;
    }

    private DataManager() {
        coupons = new ArrayList<>();
        earnItems = new ArrayList<>();
        init();
    }

    public void addCoupon(Coupon newCoupon) {
        coupons.add(newCoupon);
    }


    public void removeCoupon(Coupon rCoupon) {
        coupons.add(rCoupon);
    }

    public Coupon getCoupon(int position) {
        if (coupons.size() > position)
            return coupons.get(position);
        else return null;
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void addEarn(EarnItem earnItem) {
        earnItems.add(earnItem);
    }

    public EarnItem getEarnIyem(int position) {
        if (earnItems.size() < position)
            return earnItems.get(position);
        else return null;
    }

    public List<EarnItem> getEarnItems() {
        return earnItems;
    }

    private void init() {
        addCoupon(new Coupon("50%", R.drawable.icon, 28000));
        addCoupon(new Coupon("20%", R.drawable.icon, 11500));
        addCoupon(new Coupon("10%", R.drawable.icon, 6000));
        addCoupon(new Coupon("200$ PS Gift Card", R.drawable.icon, 75000));
        addCoupon(new Coupon("100$ PS Gift Card", R.drawable.icon, 38000));
        addCoupon(new Coupon("50$ PS Gift Card", R.drawable.icon, 19500));
        addCoupon(new Coupon("25$ PS Gift Card", R.drawable.icon, 9900));
        addCoupon(new Coupon("10$ PS Gift Card", R.drawable.icon, 4000));

        addEarn(new EarnItem("Quick offers",R.drawable.icon));
        addEarn(new EarnItem("Pro tasks",R.drawable.icon));
        addEarn(new EarnItem("Daily offers",R.drawable.icon));
        addEarn(new EarnItem("Watch Video",R.drawable.icon));
        addEarn(new EarnItem("Rate us",R.drawable.icon));
    }
}
