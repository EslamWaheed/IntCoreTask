package com.eslamwaheed.www.intcoretask.apimodels.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static String Base_URL;

    public static final String API_KEY = "97d00ec2ce73d12ed605e60ff3bba8cc";

    private static HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder().addInterceptor(interceptor);

    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build());

    private static Retrofit retrofit = builder.build();

    public static <S> S buildeService(Class<S> serviceType, String Base_URL) {
        ApiClient.Base_URL = Base_URL;
        return retrofit.create(serviceType);
    }
}
