package com.scoproject.contactmanagement.api;

import com.scoproject.contactmanagement.network.NetworkService;

import java.util.HashMap;

/**
 * Created by ibnumuzzakkir on 02/03/2017.
 * Android Developer
 * Garena Indonesia
 */

public class AddContactService {
    private NetworkService mNetworkService = null;
    public void init(HashMap<String, String> param){

    }

    public AddContactService(NetworkService networkService){
        mNetworkService = networkService;

    }
}
