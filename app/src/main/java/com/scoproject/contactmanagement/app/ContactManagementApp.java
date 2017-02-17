package com.scoproject.contactmanagement.app;

import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

/**
 * Created by ibnumuzzakkir on 16/02/2017.
 * Android Developer
 * Garena Indonesia
 */

public class ContactManagementApp extends MultiDexApplication {

    private static ContactManagementApp mInstance;
    private AppComponent mAppComponent;
    public static ContactManagementApp getApp() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        //prepare the dependency injection
        mInstance = this;
        mAppComponent = AppComponent.Initializer.init(this);
    }

    public AppComponent component() {
        return mAppComponent;
    }


}
