package ua.andromad.testassignmentaxon.services;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitNetworkService {
    private static RetrofitNetworkService mInstance;
    private Retrofit mRetrofit;
    private static final String BASE_URL = "https://randomuser.me/api/";

    private RetrofitNetworkService() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);

        okHttpClient.addInterceptor(interceptor);

        Retrofit.Builder retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        retrofit.client(okHttpClient.build());

        mRetrofit = retrofit.build();
    }

    public static RetrofitNetworkService getInstance() {
        if (mInstance == null) {
            mInstance = new RetrofitNetworkService();
        }

        return mInstance;
    }

    public JSONPlaceHolderApi getJSONApi() {
        return mRetrofit.create(JSONPlaceHolderApi.class);
    }
}
