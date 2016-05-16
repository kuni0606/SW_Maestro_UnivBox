package com.project.smums;

import android.app.Activity;
import android.widget.Toast;

public class Backpress {

	private long backKeyPressedTime = 0;
    private Toast toast;
 
    private Activity activity;
 
    public Backpress(Activity context) {
        this.activity = context;
    }
 
    public void onBackPressed() {
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            showGuide();
            return;
        }
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            activity.finish();
            toast.cancel();
        }
    }
 
    public void showGuide() {
        toast = Toast.makeText(activity,
                "한번 더 누르시면 앱을 종료합니다", Toast.LENGTH_SHORT);
        toast.show();
    }

}
