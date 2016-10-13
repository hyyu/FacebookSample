package com.adanibo.facebooksample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;

import java.util.ArrayList;

public class MainActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        setContentView(R.layout.activity_main);

        LinearLayout fbBtnScn = (LinearLayout) findViewById(R.id.fb_button);
        fbBtnScn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main:
                ArrayList<String> perms = new ArrayList<>();
                perms.add("publish_actions");

                LoginManager.getInstance().logInWithPublishPermissions(this, perms);
            default:
                break;
        }
    }

}
