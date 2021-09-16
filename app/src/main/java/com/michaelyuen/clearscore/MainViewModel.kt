package com.michaelyuen.clearscore

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.michaelyuen.clearscore.network.ApiService
import com.michaelyuen.clearscore.data.CreditInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

val TAG: String = MainViewModel::class.java.simpleName
class MainViewModel: ViewModel() {

    val mCreditInfo = MutableLiveData<CreditInfo?>()

    fun getCreditInfo(apiService: ApiService) {
        CoroutineScope(Dispatchers.IO).launch {
            apiService.getCreditInfo().enqueue(object : Callback<CreditInfo?> {
                override fun onResponse(call: Call<CreditInfo?>, response: Response<CreditInfo?>) {
                    mCreditInfo.postValue(response.body())
                }

                override fun onFailure(call: Call<CreditInfo?>, t: Throwable) {
                    Log.e(TAG, t.toString())
                    mCreditInfo.postValue(null)
                }
            })
        }
    }
}