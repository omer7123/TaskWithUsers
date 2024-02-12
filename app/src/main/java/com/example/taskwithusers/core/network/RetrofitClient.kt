package com.example.taskwithusers.core.network

import com.example.taskwithusers.data.remote.UserApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module{
    factory { provideOkHttpClient() }
    factory { provideRetrofit(get()) }
    factory { provideApi(get()) }
}

fun provideOkHttpClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

    return OkHttpClient().newBuilder().addInterceptor(interceptor).build()
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://randomuser.me/")
        .build()

}

fun provideApi(retrofit: Retrofit):UserApi{
    return retrofit.create(UserApi::class.java)
}

