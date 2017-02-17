package com.scoproject.contactmanagement.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by ibnumuzzakkir on 17/02/2017.
 * Android Developer
 * Garena Indonesia
 */

public class Contact implements Serializable {
    @SerializedName("id")
    public long id;
    @SerializedName("first_name")
    public String first_name;
    @SerializedName("last_name")
    public String last_name;
    @SerializedName("profile_pic")
    public String profile_pic;
    @SerializedName("url")
    public String url;
}
