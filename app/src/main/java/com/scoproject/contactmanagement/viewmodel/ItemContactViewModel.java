package com.scoproject.contactmanagement.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;

import com.scoproject.contactmanagement.data.Contact;

/**
 * Created by ibnumuzzakkir on 17/02/2017.
 * Android Developer
 * Garena Indonesia
 */

public class ItemContactViewModel extends BaseObservable {
    private Contact mContact;
    private Context mContext;

    public ItemContactViewModel(Contact contact, Context context){
        this.mContext = context;
        this.mContact = contact;
    }

    public String getId(){
        return String.valueOf(mContact.id);
    }

    public String getFullName(){
        return mContact.first_name + " " +mContact.last_name;
    }

    public String getProfPic(){
        return mContact.profile_pic;
    }

    public String getUrl(){
        return  mContact.url;
    }
}
