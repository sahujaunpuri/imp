package com.gnnsnowszerro.psngiftcardsgenerator.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.gnnsnowszerro.psngiftcardsgenerator.R;

public class Alert extends AlertSimple {

    public static final String TITLE = "title";
    public static final String MESSAGE = "message";
    public static final String HAS_OK = "hasok";

    private TextView title, message;
    private Button ok;


    public static Alert newInstance(String title, String message, boolean hasok) {

        Bundle args = new Bundle();
        args.putString(TITLE, title);
        args.putString(MESSAGE, message);
        args.putBoolean(HAS_OK, hasok);
        Alert fragment = new Alert();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setDialogView() {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.dialog_sorry, null);


        title = (TextView) v.findViewById(R.id.title);
        message = (TextView) v.findViewById(R.id.message);
        ok = (Button) v.findViewById(R.id.positive_button);

        if (getArguments() != null) {

            String titleText = getArguments().getString(TITLE);
            String messageText = getArguments().getString(MESSAGE);
            boolean hasok = getArguments().getBoolean(HAS_OK, true);

            title.setText(titleText);
            message.setText(messageText);

            if (hasok) {
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dismiss();
                    }
                });
            } else {
                ok.setVisibility(View.GONE);
            }

        }

        dialog.setContentView(v);

        Window window = dialog.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

    }

}
