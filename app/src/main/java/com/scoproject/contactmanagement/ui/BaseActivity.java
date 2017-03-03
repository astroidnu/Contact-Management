package com.scoproject.contactmanagement.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.scoproject.contactmanagement.api.GetContactService;
import com.scoproject.contactmanagement.app.AppComponent;
import com.scoproject.contactmanagement.app.ContactManagementApp;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

/**
 * Created by ibnumuzzakkir on 03/03/2017.
 * Android Developer
 * Garena Indonesia
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateComponent(ContactManagementApp.getApp().component());
    }
    /**
     * Implement this method to inject the dependency for activity
     *
     * @param appComponent the base app component
     */
    protected abstract void onCreateComponent(AppComponent appComponent);

}
