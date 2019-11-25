package ir.jaryaan.matchmatch.network;

import android.util.Log;

import com.google.gson.Gson;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import ir.jaryaan.matchmatch.MatchMatchApplication;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ehsun on 5/12/2017.
 */

public class ServiceUtils {

    public static Retrofit createDefaultRetrofitBuilder(String baseUrl, Gson gson, Interceptor... interceptors) {

        OkHttpClient.Builder okHttpClientBuilder = createDefaultClient();
        if (interceptors != null && interceptors.length > 0) {
            for (Interceptor interceptor : interceptors) {
                okHttpClientBuilder.interceptors().add(interceptor);
            }
        }

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClientBuilder.build())
                .build();
    }

    public static Interceptor getLoggingInterceptor(HttpLoggingInterceptor.Level logLevel) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(logLevel);
        return loggingInterceptor;
    }

    public static OkHttpClient.Builder createDefaultClient() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
                .followSslRedirects(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES);

        return okHttpClientBuilder;
    }
}
