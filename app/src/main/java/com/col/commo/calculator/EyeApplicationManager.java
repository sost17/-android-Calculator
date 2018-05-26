package com.col.commo.calculator;

import android.app.Activity;
import android.app.Application;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by commo on 2017/3/28.
 */

public class EyeApplicationManager extends Application {
    private List<Activity> activityList = new LinkedList<Activity>();
    private static EyeApplicationManager instance;

    private EyeApplicationManager() {
    }

    public static EyeApplicationManager getInstance() {
        if (null == instance) {
            instance = new EyeApplicationManager();
        }
        return instance;
    }

    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public void exit() {
        for (Activity activity : activityList) {
            activity.finish();
        }
        System.exit(0);
    }
}
