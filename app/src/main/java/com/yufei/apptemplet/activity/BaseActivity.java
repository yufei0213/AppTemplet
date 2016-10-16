package com.yufei.apptemplet.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Bundle;

import com.yufei.apptemplet.utils.ActivityCollector;

/**
 * Created by wangyufei on 16/9/3.
 */
public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

        ActivityCollector.removeActivity(this);
    }
}
