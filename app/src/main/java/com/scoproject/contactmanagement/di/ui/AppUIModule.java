package com.scoproject.contactmanagement.di.ui;

import com.scoproject.contactmanagement.di.scope.ApplicationScope;
import com.scoproject.contactmanagement.view.navigation.ActivityScreenSwitcher;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ibnumuzzakkir on 16/02/2017.
 * Android Developer
 * Garena Indonesia
 */

@Module
public class AppUIModule {

    @Provides
    @ApplicationScope
    ActivityScreenSwitcher provideActivityScreenSwitcher() {
        return new ActivityScreenSwitcher();
    }
}

