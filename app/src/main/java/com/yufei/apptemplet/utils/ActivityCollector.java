package com.yufei.apptemplet.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyufei on 16/9/3.
 */
public class ActivityCollector {

    private static List<Activity> activities = new ArrayList<Activity>();

    /**
     * cannot be instantiated
     */
    private ActivityCollector() {

        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * add activity to list
     *
     * @param activity
     */
    public static void addActivity(Activity activity) {

        activities.add(activity);
    }

    /**
     * remove activity from list
     *
     * @param activity
     */
    public static void removeActivity(Activity activity) {

        try {

            activities.remove(activity);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    /**
     * stop the special activity
     *
     * @param activityClass
     */
    public static void finshActivity(Class<?> activityClass) {

        Activity finished = null;

        for (Activity activity : activities) {

            if(activityClass.equals(activity.getClass())) {

                activity.finish();
                finished = activity;
                break;
            }
        }

        if(finished != null)
            removeActivity(finished);
    }

    /**
     * stop activities instead of the special activity
     *
     * @param activityClass
     */
    public static void finishOthers(Class<?> activityClass) {

        List<Activity> delActivities = new ArrayList<Activity>();

        for(Activity activity : activities) {

            if(!activityClass.equals(activity.getClass())) {

                activity.finish();
                delActivities.add(activity);
            }
        }

        activities.removeAll(delActivities);
    }

    /**
     * stop all activities, exit application
     */
    public static void finishAll() {

        for (Activity activity : activities) {

            if(!activity.isFinishing())
                activity.finish();
        }

        activities.clear();
    }

    /**
     * get size of current activities
     *
     * @return activity count
     */
    public static int size() {

        return activities.size();
    }
}
