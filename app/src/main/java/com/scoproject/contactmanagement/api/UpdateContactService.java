package com.scoproject.contactmanagement.api;

import com.scoproject.contactmanagement.data.Contact;
import com.scoproject.contactmanagement.network.NetworkService;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ibnumuzzakkir on 02/03/2017.
 * Android Developer
 * Garena Indonesia
 */

public class UpdateContactService {
    private NetworkService mNetworkService = null;
    private HashMap<String, String> data;
    private String mId;
    public void init(String id, HashMap<String, String> param){
        mId = id;
        data = new HashMap<>();
        data = param;

    }

    public UpdateContactService(NetworkService networkService){
        mNetworkService = networkService;

    }

    public void updateContact(final AddContactService.GetResponseCallback callback){
        mNetworkService.updateContact(mId, data)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(throwable -> {
                    return Observable.error(throwable);
                })
                .subscribe(new Observer<Contact>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Contact value) {
                        callback.onSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e);
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    public interface GetResponseCallback{
        void onSuccess(Contact dataList);
        void onError(Throwable e);
    }
}
