package com.michaelyuen.clearscore

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.michaelyuen.clearscore.databinding.ActivityMainBinding
import com.michaelyuen.clearscore.network.ApiService
import com.michaelyuen.clearscore.network.ServiceManager
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    lateinit var mViewModel: MainViewModel
    lateinit var mApiService: ApiService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        mViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mViewModel.mCreditInfo.observe(this) { creditInfo ->
            creditInfo?.let {
                val score = it.creditReportInfo.score.toDouble()
                val totalScore = it.creditReportInfo.maxScoreValue.toDouble()
                val scorePercentage = ceil(((score/totalScore) *100))
                binding.showScore = true
                binding.tvScore.text = score.toString()
                binding.tvOutOf.text = String.format(getString(R.string.total_score_out_of
                ), totalScore.toString())
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    binding.progressBar.setProgress(scorePercentage.toInt(), true)
                } else {
                    binding.progressBar.progress = scorePercentage.toInt()
                }
            } ?: kotlin.run {
                Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show()
            }

        }
        mApiService = ServiceManager.client.create(ApiService::class.java)

        binding.btGetInfo.setOnClickListener {
            mViewModel.getCreditInfo(mApiService)
        }
    }


}