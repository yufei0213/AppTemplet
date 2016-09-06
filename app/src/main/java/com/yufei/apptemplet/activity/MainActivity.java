package com.yufei.apptemplet.activity;

import android.os.Bundle;
import android.view.View;

import com.yufei.apptemplet.R;
import com.yufei.apptemplet.utils.AlertUtil;

public class MainActivity extends BaseActivity {

    private AlertUtil alertUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {

        super.onResume();

        alertUtil = AlertUtil.createAlert(MainActivity.this);

        alertUtil.setMessage("test");
        alertUtil.setPositiveButton("ok", new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alertUtil.dismiss();
            }
        });

        alertUtil.setLeftButton("cancel", new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alertUtil.dismiss();
            }
        });

        alertUtil.setRightButton("ok", new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alertUtil.dismiss();
            }
        });

        alertUtil.show();
    }
}