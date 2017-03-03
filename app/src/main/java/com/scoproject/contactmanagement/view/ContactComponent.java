package com.scoproject.contactmanagement.view;

import com.scoproject.contactmanagement.app.AppComponent;

import dagger.Component;

/**
 * Created by ibnumuzzakkir on 03/03/2017.
 * Android Developer
 * Garena Indonesia
 */
@ContactScope
@Component(dependencies = {AppComponent.class})
public interface ContactComponent {
    void inject(ContactActivity contactActivity);
}
