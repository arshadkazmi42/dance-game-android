package com.arshad.dancegame.global;

import android.app.Application;

public class AppController extends Application {

    private static AppController instance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        FontsOverride.setDefaultFont(this, "MONOSPACE", "semi-bold.ttf");
        instance = this;
    }

    public static synchronized AppController getInstance() {
        return instance;
    }
}
