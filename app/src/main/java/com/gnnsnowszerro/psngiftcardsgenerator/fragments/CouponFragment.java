package com.gnnsnowszerro.psngiftcardsgenerator.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gnnsnowszerro.psngiftcardsgenerator.R;
import com.gnnsnowszerro.psngiftcardsgenerator.custom.CustomToolbar;
import com.gnnsnowszerro.psngiftcardsgenerator.dialogs.Alert;
import com.gnnsnowszerro.psngiftcardsgenerator.helpers.DataManager;
import com.gnnsnowszerro.psngiftcardsgenerator.helpers.PrefenceHelper;
import com.gnnsnowszerro.psngiftcardsgenerator.models.Coupon;

import java.util.HashMap;


public class CouponFragment extends Fragment implements View.OnClickListener {


    public static final String COUPON_POSITION = "COUPON_POSITION";

    private TextView mDesc;
    private TextView mPrice;
    private ImageView mLogo;

    private EditText email;

    private Coupon coupon;

    private int coins;
    private CustomToolbar toolbar;

    private HashMap<String,String> messages;


    public static CouponFragment newInstance(int position) {
        CouponFragment fragment = new CouponFragment();
        Bundle args = new Bundle();
        args.putInt(COUPON_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_coupon, container, false);

        coins = PrefenceHelper.getInstance(getContext()).loadCoins();

        toolbar = (CustomToolbar) view.findViewById(R.id.toolbar);

        toolbar.setNavigationIcon(R.drawable.back);

        toolbar.setCoinsText(String.valueOf(coins));

        ((AppCompatActivity)getContext()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getContext()).getSupportActionBar().setTitle(R.string.redeem);

        mDesc = (TextView) view.findViewById(R.id.desc);
        mPrice = (TextView) view.findViewById(R.id.price);
        mLogo = (ImageView) view.findViewById(R.id.logo);

        email = (EditText) view.findViewById(R.id.email);

        view.findViewById(R.id.generate).setOnClickListener(this);
        view.findViewById(R.id.redeem).setOnClickListener(this);

        if (getArguments() != null) {
            int position = getArguments().getInt(COUPON_POSITION, 0);
            coupon = DataManager.getInstance().getCoupon(position);
            mDesc.setText(coupon.getDesc());
            mPrice.setText(getString(R.string.coins,coupon.getPrice()));
            mLogo.setImageResource(coupon.getLogo());
        }
        return view;
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
            showAlert("Sorry", "You don’t have enough coins", true);
        }
    }

    private void redeemClick(String emailText) {
        if (emailText.isEmpty()) {
            showAlert("No email address", "Email address can’t be blank", true);
        } else {
            if (!emailText.contains("@"))
                showAlert("Invalid Email", "Your Email address in invalid", true);
            else showAlert("Error", "Generate code at first", true);
        }
    }

    private void showAlert(String title, String message, boolean hasok) {
        Alert.newInstance(title, message, hasok).show( ((AppCompatActivity)getContext()).getSupportFragmentManager(), title);
    }
}
