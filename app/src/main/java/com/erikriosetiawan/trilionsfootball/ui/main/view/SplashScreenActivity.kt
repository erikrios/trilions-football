package com.erikriosetiawan.trilionsfootball.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.lifecycle.ViewModelProviders
import com.erikriosetiawan.trilionsfootball.R
import com.erikriosetiawan.trilionsfootball.ui.main.viewmodel.SplashScreenViewModel
import com.erikriosetiawan.trilionsfootball.ui.main.viewmodel.SplashScreenViewModelFactory

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        setUpViewModel()
        setTransparentStatusBar()
    }

    /**
     * Setup view model and view model factory for this activity
     */
    private fun setUpViewModel() {
        val viewModelFactory = SplashScreenViewModelFactory(this)
        ViewModelProviders.of(this, viewModelFactory).get(SplashScreenViewModel::class.java)
    }

    /**
     * Create transparent status bar
     */
    private fun setTransparentStatusBar() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }
}
