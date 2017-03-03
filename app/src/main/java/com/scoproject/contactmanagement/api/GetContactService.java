package com.scoproject.contactmanagement.api;

import com.scoproject.contactmanagement.app.AppConst;
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

public class GetContactService {
    private NetworkService mNetworkService = null;
    private String mContactId;
    private boolean mIsGetAllContact;
    public void init(String contacId,  boolean isGetAllContact){
        mContactId = contacId;
        mIsGetAllContact = isGetAllContact;
    }

    public GetContactService(NetworkService networkService){
        mNetworkService = networkService;

    }

    public void getContact(final AddContactService.GetResponseCallback callback){
        if(mIsGetAllContact){
            mNetworkService.getAllContact()
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
        }else{
            mNetworkService.getContact(mContactId)
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
    }

    public interface GetResponseCallback{
        void onSuccess(Contact dataList);
        void onError(Throwable e);
    }
}
