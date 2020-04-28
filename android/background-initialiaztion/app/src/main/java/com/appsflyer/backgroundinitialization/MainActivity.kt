package com.appsflyer.backgroundinitialization

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.appsflyer.AppsFlyerLib

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as BackgroundInitialization).appsflyerQueue.submit {
            AppsFlyerLib.getInstance().startTracking(this)
        }
    }
}