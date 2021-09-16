package com.michaelyuen.clearscore.network

import com.michaelyuen.clearscore.data.CreditInfo
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/endpoint.json")
    fun getCreditInfo(): Call<CreditInfo?>
}