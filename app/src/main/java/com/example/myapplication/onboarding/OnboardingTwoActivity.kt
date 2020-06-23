package com.example.myapplication.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_onboarding_two.*


class OnboardingTwoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_two)

        btn_home.setOnClickListener {
            val intent = Intent(this@OnboardingTwoActivity,
                OnboardingTreeActivity::class.java)
            startActivity(intent)
        }
    }
}
