package com.gnnsnowszerro.psngiftcardsgenerator.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.gnnsnowszerro.psngiftcardsgenerator.R;

public class CustomToolbar extends Toolbar {

    private TextView coins, titleView;

    public CustomToolbar(Context context) {
        super(context);
        init(context);
    }

    public CustomToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.custom_toolbar, this);

        this.coins = (TextView) v.findViewById(R.id.coins_text);
        this.titleView = (TextView) v.findViewById(R.id.title_text);

    }

    public void setCoinsText(String text) {
        if (coins != null)
            coins.setText(text);

    }

    @Override
    public void setTitle(@StringRes int resId) {
        if (titleView != null)
            titleView.setText(resId);
    }

    @Override
    public void setTitle(CharSequence title) {
        if (titleView != null)
            this.titleView.setText(title);
    }
}
