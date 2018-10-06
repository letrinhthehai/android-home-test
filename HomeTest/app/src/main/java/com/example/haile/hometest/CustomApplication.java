package com.example.haile.hometest;

import android.app.Application;
import android.content.Context;

public class CustomApplication extends Application {
    private static CustomApplication INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }
}
