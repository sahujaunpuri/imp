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


    public static final int OFFER_TORO = 0;
    public static final int NATIVEX = 1;
    public static final int ADXMI = 2;
    public static final int ADCOLONY = 3;
    public static final int RATE_US = 4;

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
        addCoupon(new Coupon("50%", R.drawable.discont, 28000));
        addCoupon(new Coupon("20%", R.drawable.discont, 11500));
        addCoupon(new Coupon("10%", R.drawable.discont, 6000));
        addCoupon(new Coupon("200$ PS Gift Card", R.drawable.gift_card, 75000));
        addCoupon(new Coupon("100$ PS Gift Card", R.drawable.gift_card, 38000));
        addCoupon(new Coupon("50$ PS Gift Card", R.drawable.gift_card, 19500));
        addCoupon(new Coupon("25$ PS Gift Card", R.drawable.gift_card, 9900));
        addCoupon(new Coupon("10$ PS Gift Card", R.drawable.gift_card, 4000));

        addEarn(new EarnItem(OFFER_TORO,"Quick offers",R.drawable.quick));
        addEarn(new EarnItem(NATIVEX,"Pro tasks",R.drawable.pro));
        addEarn(new EarnItem(ADXMI,"Daily offers",R.drawable.daily));
        addEarn(new EarnItem(ADCOLONY,"Watch Video",R.drawable.video));
        addEarn(new EarnItem(RATE_US,"Rate us",R.drawable.rate));
    }
}
