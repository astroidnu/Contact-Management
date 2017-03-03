package com.scoproject.contactmanagement.app;

import android.app.Application;

import com.google.gson.Gson;
import com.scoproject.contactmanagement.api.GetContactService;
import com.scoproject.contactmanagement.di.app.AppModule;
import com.scoproject.contactmanagement.di.app.IAppComponent;
import com.scoproject.contactmanagement.di.scope.ApplicationScope;
import com.scoproject.contactmanagement.di.ui.AppUIModule;
import com.scoproject.contactmanagement.network.NetworkModule;

import java.io.File;

import dagger.Component;

/**
 * Created by ibnumuzzakkir on 16/02/2017.
 * Android Developer
 * Garena Indonesia
 */
@ApplicationScope
@Component(
        modules = {AppModule.class, NetworkModule.class, AppUIModule.class}
)
public interface AppComponent extends IAppComponent{
    final static class Initializer {
        static AppComponent init(ContactManagementApp app) {
            File cacheFile = new File(app.getCacheDir(), "responses");
            return DaggerAppComponent.builder()
                    .appModule(new AppModule(app))
                    .networkModule(new NetworkModule(cacheFile))
                    .build();
        }

        private Initializer() {
        } // No instances.
    }
    GetContactService getContactService();
    Application getApplication();
    Gson getGson();

    /*API Service Component*/
}
