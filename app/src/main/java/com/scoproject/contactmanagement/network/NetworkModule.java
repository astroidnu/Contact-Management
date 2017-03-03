package com.scoproject.contactmanagement.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.scoproject.contactmanagement.BuildConfig;
import com.scoproject.contactmanagement.api.AddContactService;
import com.scoproject.contactmanagement.api.GetContactService;
import com.scoproject.contactmanagement.api.UpdateContactService;
import com.scoproject.contactmanagement.di.scope.ApplicationScope;

import java.io.File;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ibnumuzzakkir on 01/03/2017.
 * Android Developer
 * Garena Indonesia
 */
@Module
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
                .client(getUnsafeOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private OkHttpClient getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };
            Cache cache = null;
            try {
                cache = new Cache(cacheFile, 10 * 1024 * 1024); //10MiB
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .cache(cache)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .hostnameVerifier((hostname, session) -> true)
                    .sslSocketFactory(sslSocketFactory)
                    .build();

            return okHttpClient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
