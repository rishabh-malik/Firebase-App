package com.example.rishabh.fireapp;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Rishabh on 19-06-2017.
 */

public class FireApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
