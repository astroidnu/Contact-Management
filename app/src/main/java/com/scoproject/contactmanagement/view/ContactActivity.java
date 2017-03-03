package com.scoproject.contactmanagement.view;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.scoproject.contactmanagement.R;
import com.scoproject.contactmanagement.api.AddContactService;
import com.scoproject.contactmanagement.api.GetContactService;
import com.scoproject.contactmanagement.app.AppComponent;
import com.scoproject.contactmanagement.data.Contact;
import com.scoproject.contactmanagement.ui.BaseActivity;

import javax.inject.Inject;

public class ContactActivity extends BaseActivity {
    @Inject
    GetContactService mGetContactService;

    @Inject
    Gson gson;

    private Contact mContact;
    private ContactComponent mComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getAllContact();
    }

    @Override
    protected void onCreateComponent(AppComponent appComponent) {
        mComponent = DaggerContactComponent.builder().appComponent(appComponent).build();
        mComponent.inject(this);
    }

    private void getAllContact(){
        mGetContactService.init("", true);
        mGetContactService.getContact(new AddContactService.GetResponseCallback() {
            @Override
            public void onSuccess(Contact dataList) {
                mContact = dataList;
            }

            @Override
            public void onError(Throwable e) {
                Log.d(getClass().getName(), e.getMessage());
            }
        });
    }
}
