package com.appsflyer.backgroundinitialization

import android.app.Application
import com.appsflyer.AppsFlyerLib
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class BackgroundInitialization : Application() {
    val appsflyerQueue: ExecutorService = Executors.newSingleThreadExecutor()
    override fun onCreate() {
        super.onCreate()
        appsflyerQueue.submit {
            AppsFlyerLib.getInstance().run {
                setDebugLog(true)
                setCollectIMEI(false)
                setCollectAndroidID(false)
                init("appKey2", null, this@BackgroundInitialization)
            }
        }
    }
}