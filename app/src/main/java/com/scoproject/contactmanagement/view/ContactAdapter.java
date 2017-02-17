package com.scoproject.contactmanagement.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.scoproject.contactmanagement.R;
import com.scoproject.contactmanagement.data.Contact;
import com.scoproject.contactmanagement.databinding.ItemContactBinding;
import com.scoproject.contactmanagement.viewmodel.ItemContactViewModel;

import java.util.Collections;
import java.util.List;


/**
 * Created by ibnumuzzakkir on 17/02/2017.
 * Android Developer
 * Garena Indonesia
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>{

    private List<Contact> mContactList;

    public ContactAdapter(){
        this.mContactList = Collections.emptyList();
    }

    public void setContactList(List<Contact> contactList) {
        this.mContactList = contactList;
        notifyDataSetChanged();
    }

    @Override
    public ContactAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemContactBinding itemContactBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_contact, parent, false);
        return new ContactAdapterViewHolder(itemContactBinding);
    }

    @Override
    public void onBindViewHolder(ContactAdapterViewHolder holder, int position) {
        holder.bindContact(mContactList.get(position));
    }

    @Override
    public int getItemCount() {
        return mContactList.size();
    }

    public static class ContactAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemContactBinding mItemContactBinding;

        public ContactAdapterViewHolder(ItemContactBinding itemContactBinding) {
            super(itemContactBinding.itemContact);
            this.mItemContactBinding = itemContactBinding;
        }

        void bindContact(Contact contact) {
            if (mItemContactBinding.getContactViewModel() == null) {
                mItemContactBinding.setContactViewModel(
                        new ItemContactViewModel(contact, itemView.getContext()));
            } else {
                mItemContactBinding.getContactViewModel().setContact(contact);
            }
        }
    }
}
