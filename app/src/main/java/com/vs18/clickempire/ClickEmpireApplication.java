package com.vs18.clickempire;

import android.app.Application;

import com.vs18.clickempire.manager.GameManager;

/**
 * Application class for Click Empire.
 * Initializes global game components.
 */
public class ClickEmpireApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        GameManager.initialize(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        GameManager.release();
    }
}
