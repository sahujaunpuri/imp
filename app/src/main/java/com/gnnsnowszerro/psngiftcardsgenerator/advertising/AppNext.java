package com.gnnsnowszerro.psngiftcardsgenerator.advertising;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.appnext.appnextsdk.API.AppnextAPI;
import com.appnext.appnextsdk.API.AppnextAd;
import com.appnext.appnextsdk.API.AppnextAdRequest;
import com.appnext.base.Appnext;
import com.gnnsnowszerro.psngiftcardsgenerator.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;


/**
 * Created by mykola on 18.06.17.
 */

public class AppNext extends Advertising {
    private Context context;
    private AppnextAPI api;
    private AppnextAd ad;
    private View view;
    public static final String PLACEMENT_ID = "71e1876b-4594-4065-8d8a-9739c2e519de";

    public AppNext(Context context, View view) {
        super(context);
        this.context = context;
        this.view = view;
    }


    @Override
    public void initAdv() {
        Appnext.init(context);

        api = new AppnextAPI(context, PLACEMENT_ID);
        api.setAdListener(new AppnextAPI.AppnextAdListener() {
            @Override
            public void onError(String error) {

            }

            @Override
            public void onAdsLoaded(ArrayList<AppnextAd> arrayList) {
                if (arrayList.isEmpty())
                    return;
                int position = new Random().nextInt(arrayList.size());
                ad = arrayList.get(position);

                view.findViewById(R.id.banner_view).setVisibility(View.VISIBLE);
                Picasso.with(context).load(ad.getImageURL()).into((ImageView) view.findViewById(R.id.icon));
                ((TextView) view.findViewById(R.id.title)).setText(ad.getAdTitle());
                ((TextView) view.findViewById(R.id.rating)).setText(ad.getStoreRating());
                ((Button) view.findViewById(R.id.install)).setText(ad.getButtonText());

                view.findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        api.adClicked(ad);
                    }
                });

                view.findViewById(R.id.privacy).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        api.privacyClicked(ad);
                    }
                });

                api.adImpression(ad);
            }
        });

        api.loadAds(new AppnextAdRequest());

        api.setCreativeType(AppnextAPI.TYPE_MANAGED);
    }

    @Override
    public void finalizeAdv() {
        api.finish();
    }

    @Override
    public void showAdv() {

    }
}
