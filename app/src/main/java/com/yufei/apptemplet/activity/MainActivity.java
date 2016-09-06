package com.yufei.apptemplet.activity;

import android.os.Bundle;

import com.yufei.apptemplet.R;
import com.yufei.apptemplet.view.component.Alert;

public class MainActivity extends BaseActivity {

    private Alert alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {

        super.onResume();
    }
}