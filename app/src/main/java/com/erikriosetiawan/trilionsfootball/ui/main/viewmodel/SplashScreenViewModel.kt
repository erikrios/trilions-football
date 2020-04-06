package com.erikriosetiawan.trilionsfootball.ui.main.viewmodel

import android.app.Activity
import android.content.Intent
import android.os.Handler
import androidx.lifecycle.ViewModel
import com.erikriosetiawan.trilionsfootball.R
import com.erikriosetiawan.trilionsfootball.ui.main.view.MainActivity

class SplashScreenViewModel(private val activity: Activity) : ViewModel() {

    companion object {
        // Splash screen delay
        private const val SPLASH_DELAY = 5000L
    }

    // Declare the handler and runnable
    private var handler: Handler? = null
    private val runnable: Runnable = Runnable {
        // Start the MainActivity, add transition animation, and finish the current activity
        val intent = Intent(activity.baseContext, MainActivity::class.java)
        activity.startActivity(intent)
        activity.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        activity.finish()
    }

    init {
        // Instantiate the handler
        handler = Handler()
        // Start the runnable
        handler?.postDelayed(runnable, SPLASH_DELAY)
    }

    override fun onCleared() {
        super.onCleared()
        // Remove the runnable when view model completely cleared
        handler?.removeCallbacks(runnable)
    }
}