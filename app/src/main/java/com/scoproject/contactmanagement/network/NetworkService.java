package com.scoproject.contactmanagement.network;

import com.scoproject.contactmanagement.data.Contact;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by ibnumuzzakkir on 16/02/2017.
 * Android Developer
 * Garena Indonesia
 */

public interface NetworkService {
    @GET("/contacts.json")
    Observable<Contact> getAllContact();

    @GET("/contacts/{id}.json")
    Observable<Contact> getContact(@Path("id") String id);

    @FormUrlEncoded
    @POST("/contacts.json")
    Observable<Contact> addContact(@Body HashMap<String, String> data);

    @FormUrlEncoded
    @PUT("/contacts/{id}.json")
    Observable<Contact> updateContact(@Path("id") String id, @Body HashMap<String, String> data);

}
