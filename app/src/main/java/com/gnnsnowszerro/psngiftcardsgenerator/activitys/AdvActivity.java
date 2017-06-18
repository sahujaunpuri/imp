package com.gnnsnowszerro.psngiftcardsgenerator.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gnnsnowszerro.psngiftcardsgenerator.R;
import com.gnnsnowszerro.psngiftcardsgenerator.advertising.Advertising;
import com.gnnsnowszerro.psngiftcardsgenerator.advertising.Adxmi;
import com.gnnsnowszerro.psngiftcardsgenerator.advertising.OfferToro;

import static com.gnnsnowszerro.psngiftcardsgenerator.helpers.DataManager.ADCOLONY;
import static com.gnnsnowszerro.psngiftcardsgenerator.helpers.DataManager.ADXMI;
import static com.gnnsnowszerro.psngiftcardsgenerator.helpers.DataManager.NATIVEX;
import static com.gnnsnowszerro.psngiftcardsgenerator.helpers.DataManager.OFFER_TORO;

public class AdvActivity extends AppCompatActivity {
    private Advertising advertising;

    public static final String ADV_TYPE = "adv_type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adv);

        switch (getIntent().getIntExtra(ADV_TYPE, -1)) {
            case OFFER_TORO:
                advertising = new OfferToro(this, this);
                break;
            case NATIVEX:
                break;
            case ADXMI:
                advertising = new Adxmi(this);
                break;
            case ADCOLONY:
                break;
        }

        advertising.initAdv();
        advertising.showAdv();

    }
}
