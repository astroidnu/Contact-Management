package com.scoproject.contactmanagement.di.app;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.scoproject.contactmanagement.app.ContactManagementApp;
import com.scoproject.contactmanagement.di.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ibnumuzzakkir on 16/02/2017.
 * Android Developer
 * Garena Indonesia
 */

@Module
public class AppModule {

    private final ContactManagementApp mApp;

    public AppModule(ContactManagementApp app) {
        this.mApp = app;
    }

    @Provides
    @ApplicationScope
    Application provideApplicationContext() {
        return mApp;
    }

    @Provides
    @ApplicationScope
    Gson provideGson(){ return new Gson();}
}
