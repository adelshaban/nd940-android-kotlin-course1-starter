package com.udacity.shoestore.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.viewmodels.ShoesListViewModel
import com.udacity.shoestore.viewmodels.ShoesListViewModelHelper
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        Timber.plant(Timber.DebugTree())

        ShoesListViewModelHelper.generateDummyData(this, 10)

        // Only for tracing
        ShoesListViewModelHelper.traceViewModel(this)

    }


}
