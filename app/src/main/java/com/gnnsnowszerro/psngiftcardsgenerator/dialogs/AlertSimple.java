package com.gnnsnowszerro.psngiftcardsgenerator.dialogs;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by mykola on 27.04.17.
 */

public abstract class AlertSimple extends DialogFragment {
    private final String TAG = getClass().getSimpleName();
    protected Dialog dialog;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Log.i(TAG, "Pattern onCreateDialog");
        dialog = new Dialog(getContext());

        dialog.setCanceledOnTouchOutside(false);

        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        setDialogView();

        return dialog;
    }

    public abstract void setDialogView();
}
