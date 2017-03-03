package com.scoproject.contactmanagement.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.scoproject.contactmanagement.R;
import com.scoproject.contactmanagement.api.AddContactService;
import com.scoproject.contactmanagement.api.GetContactService;
import com.scoproject.contactmanagement.data.Contact;

import javax.inject.Inject;

public class ContactActivity extends AppCompatActivity {
    @Inject
    GetContactService mGetContactService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void getAllContact(){
        mGetContactService.init("", true);
        mGetContactService.getContact(new AddContactService.GetResponseCallback() {
            @Override
            public void onSuccess(Contact dataList) {

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
