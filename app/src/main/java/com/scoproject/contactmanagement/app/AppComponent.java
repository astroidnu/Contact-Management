package com.scoproject.contactmanagement.app;

import android.app.Application;

import com.google.gson.Gson;
import com.scoproject.contactmanagement.di.app.AppModule;
import com.scoproject.contactmanagement.di.app.IAppComponent;
import com.scoproject.contactmanagement.di.network.NetworkModule;
import com.scoproject.contactmanagement.di.scope.ApplicationScope;
import com.scoproject.contactmanagement.di.ui.AppUIModule;

import java.io.File;
import java.net.CookieManager;

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

    Application getApplication();
    Gson getGson();
}
