package com.erikriosetiawan.trilionsfootball.ui.main.viewmodel

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class SplashScreenViewModelFactory(private val activity: Activity) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        SplashScreenViewModel(activity) as T
}