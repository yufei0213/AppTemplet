package com.yufei.apptemplet.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.yufei.apptemplet.R;

/**
 * Created by wangyufei on 16/9/5.
 */
public class AlertUtil {

    private AlertDialog alertDialog;

    private View view;

    private AlertUtil(Context context) {

        view = LayoutInflater.from(context).inflate(R.layout.component_alert, null);

        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setCancelable(false);
        alertDialog.setInverseBackgroundForced(true);
    }

    public static AlertUtil createAlert(Context context) {

        return new AlertUtil(context);
    }

    public void show() {

        alertDialog.show();

        //delete default styles
        Window window = alertDialog.getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));

        alertDialog.setContentView(view);
    }

    public void dismiss() {

        alertDialog.dismiss();
    }

    public void setCancelable(boolean cancelable) {

        alertDialog.setCancelable(cancelable);
    }

    public void setMessage(String text) {

        TextView message = (TextView) view.findViewById(R.id.message);

        message.setText(text);
    }

    public void setPositiveButton(String text, View.OnClickListener listener) {

        view.findViewById(R.id.btn_layout).setVisibility(View.INVISIBLE);
        view.findViewById(R.id.ok_btn).setVisibility(View.VISIBLE);

        Button okBtn = (Button) view.findViewById(R.id.ok_btn);

        okBtn.setText(text);
        okBtn.setOnClickListener(listener);
    }

    public void setLeftButton(String text, View.OnClickListener listener) {

        view.findViewById(R.id.btn_layout).setVisibility(View.VISIBLE);
        view.findViewById(R.id.ok_btn).setVisibility(View.INVISIBLE);

        Button leftBtn = (Button) view.findViewById(R.id.left_btn);

        leftBtn.setText(text);
        leftBtn.setOnClickListener(listener);
    }

    public void setRightButton(String text, View.OnClickListener listener) {

        view.findViewById(R.id.btn_layout).setVisibility(View.VISIBLE);
        view.findViewById(R.id.ok_btn).setVisibility(View.INVISIBLE);

        Button rightBtn = (Button) view.findViewById(R.id.right_btn);

        rightBtn.setText(text);
        rightBtn.setOnClickListener(listener);
    }
}
