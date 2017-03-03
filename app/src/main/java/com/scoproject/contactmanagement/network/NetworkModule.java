package com.scoproject.contactmanagement.network;

import com.scoproject.contactmanagement.BuildConfig;
import com.scoproject.contactmanagement.api.AddContactService;
import com.scoproject.contactmanagement.api.GetContactService;
import com.scoproject.contactmanagement.api.UpdateContactService;
import com.scoproject.contactmanagement.di.scope.ApplicationScope;

import java.io.File;

import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ibnumuzzakkir on 01/03/2017.
 * Android Developer
 * Garena Indonesia
 */

public class NetworkModule {
    File cacheFile;

    public NetworkModule(File cacheFile) {
        this.cacheFile = cacheFile;
    }

    @Provides
    @ApplicationScope
    Retrofit provideCall() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.PRODUCTION_SERVER)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @ApplicationScope
    public NetworkService providesNetworkService(
            Retrofit retrofit) {
        return retrofit.create(NetworkService.class);
    }

    /*Provide All API Services*/

    @Provides
    @ApplicationScope
    public AddContactService provideAddAcontactService(
            NetworkService networkService) {
        return new AddContactService(networkService);
    }

    @Provides
    @ApplicationScope
    public GetContactService provideGetContactService(
            NetworkService networkService) {
        return new GetContactService(networkService);
    }

    @Provides
    @ApplicationScope
    public UpdateContactService provideUpdateContactService(
            NetworkService networkService) {
        return new UpdateContactService(networkService);
    }
}
