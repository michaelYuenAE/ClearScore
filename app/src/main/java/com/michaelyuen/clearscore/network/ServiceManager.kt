package com.michaelyuen.clearscore.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val END_POINT = "https://android-interview.s3.eu-west-2.amazonaws.com"
class ServiceManager {
    private val retrofit: Retrofit
    private val okHttpClient = OkHttpClient()
    init {
        retrofit = Retrofit.Builder()
            .baseUrl(END_POINT)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    companion object {
        private val manager = ServiceManager()
        val client: Retrofit
            get() = manager.retrofit
    }


}