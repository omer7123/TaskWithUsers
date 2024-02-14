package com.example.taskwithusers.core.network

import com.example.taskwithusers.data.remote.UserApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Provides an OkHttpClient instance with logging interceptor for HTTP request logging.
 * @return An instance of OkHttpClient configured with a logging interceptor.
 */
fun provideOkHttpClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

    return OkHttpClient().newBuilder().addInterceptor(interceptor).build()
}


/**
 * Provides a Retrofit instance configured with GsonConverterFactory and base URL.
 * @param okHttpClient The OkHttpClient instance to be used for network requests.
 * @return An instance of Retrofit configured with the provided OkHttpClient.
 */
fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://randomuser.me/")
        .build()

}

/**
 * Provides an implementation of the UserApi interface using the provided Retrofit instance.
 * @param retrofit The Retrofit instance used for creating the UserApi implementation.
 * @return An instance of UserApi implementation.
 */
fun provideApi(retrofit: Retrofit): UserApi {
    return retrofit.create(UserApi::class.java)
}

