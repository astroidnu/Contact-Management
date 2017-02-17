package com.scoproject.contactmanagement.view;

import android.support.v7.widget.RecyclerView;

/**
 * Created by ibnumuzzakkir on 17/02/2017.
 * Android Developer
 * Garena Indonesia
 */

public class ContactAdapter extends RecyclerView<ContactAdapter.ContactAdap> {

    public static class ContactAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemPeopleBinding mItemPeopleBinding;

        public PeopleAdapterViewHolder(ItemPeopleBinding itemPeopleBinding) {
            super(itemPeopleBinding.itemPeople);
            this.mItemPeopleBinding = itemPeopleBinding;
        }

        void bindPeople(People people) {
            if (mItemPeopleBinding.getPeopleViewModel() == null) {
                mItemPeopleBinding.setPeopleViewModel(
                        new ItemPeopleViewModel(people, itemView.getContext()));
            } else {
                mItemPeopleBinding.getPeopleViewModel().setPeople(people);
            }
        }
    }
}
