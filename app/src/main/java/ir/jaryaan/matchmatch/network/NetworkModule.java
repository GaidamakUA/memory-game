package ir.jaryaan.matchmatch.network;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ir.jaryaan.matchmatch.BuildConfig;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * Created by ehsun on 5/12/2017.
 */

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public ApiService provideApiService(@NonNull Gson gson) {
        Retrofit retrofit = ServiceUtils.createDefaultRetrofitBuilder(
                BuildConfig.BASE_URL,
                gson,
                ServiceUtils.getLoggingInterceptor(HttpLoggingInterceptor.Level.BODY));

        return retrofit.create(ApiService.class);
    }
}
