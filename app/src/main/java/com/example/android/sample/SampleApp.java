package com.example.android.sample;

import com.firebase.client.Firebase;

/**
 * Created by user on 10/4/2016.
 */

public class SampleApp extends android.app.Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
