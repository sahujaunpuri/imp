package com.gnnsnowszerro.psngiftcardsgenerator.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gnnsnowszerro.psngiftcardsgenerator.models.Coupon;
import com.gnnsnowszerro.psngiftcardsgenerator.custom.CustomToolbar;
import com.gnnsnowszerro.psngiftcardsgenerator.helpers.DataManager;
import com.gnnsnowszerro.psngiftcardsgenerator.helpers.PrefenceHelper;
import com.gnnsnowszerro.psngiftcardsgenerator.R;
import com.gnnsnowszerro.psngiftcardsgenerator.dialogs.Alert;

public class CouponActivity extends AppCompatActivity implements View.OnClickListener {

    private CustomToolbar toolbar;

    public static final String COUPON_POSITION = "COUPON_POSITION";

    private TextView mDesc;
    private TextView mPrice;
    private ImageView mLogo;

    private EditText email;

    private Coupon coupon;

    private int coins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);

        coins = PrefenceHelper.getInstance(this).loadCoins();

        toolbar = (CustomToolbar) findViewById(R.id.toolbar);

        toolbar.setLogo(R.drawable.icon);

        toolbar.setNavigationIcon(R.mipmap.ic_launcher);

        toolbar.setCoinsText(String.valueOf(coins));

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("REDEEM");


        mDesc = (TextView) findViewById(R.id.desc);
        mPrice = (TextView) findViewById(R.id.price);
        mLogo = (ImageView) findViewById(R.id.logo);

        email = (EditText) findViewById(R.id.email);

        if (getIntent().getExtras() != null) {
            int position = getIntent().getIntExtra(COUPON_POSITION, 0);
            coupon = DataManager.getInstance().getCoupon(position);
            mDesc.setText(coupon.getDesc());
            mPrice.setText(coupon.getPrice() + " coins");
            mLogo.setImageResource(coupon.getLogo());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.generate:
                generateClick(email.getText().toString());
                break;
            case R.id.redeem:
                redeemClick(email.getText().toString());
                break;
        }
    }


    private void generateClick(String emailText) {

        if (coins - coupon.getPrice() >= 0) {
            if (emailText.isEmpty()) {
                showAlert("No email address", "Email address can’t be blank", true);
            } else {
                showAlert("Excellent", "You will get your code in 72 hours", false);
            }
        } else {
            showAlert("Sorry", "ou don’t have enough coins", true);
        }
    }

    private void redeemClick(String emailText) {
        if (emailText.isEmpty()) {
            showAlert("No email address", "Email address can’t be blank", true);
        } else {
            if (!emailText.contains("@"))
                showAlert("Invalid Email", "Your Email address in invalid", true);
            else showAlert("Error","Generate code at first",true);
        }
    }

    private void showAlert(String title, String message, boolean hasok) {
        Alert.newInstance(title, message, hasok).show(getSupportFragmentManager(), title);
    }
}
