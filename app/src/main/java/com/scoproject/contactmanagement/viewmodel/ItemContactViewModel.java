package com.scoproject.contactmanagement.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
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

    @BindingAdapter("imageUrl") public static void setImageUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    public void onItemClick(View view) {
//        context.startActivity(PeopleDetailActivity.launchDetail(view.getContext(), people));
    }

    public void setContact(Contact contact) {
        this.mContact = contact;
        notifyChange();
    }
}
