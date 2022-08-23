package com.udacity.shoestore.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.viewmodels.ShoesListViewModel
import com.udacity.shoestore.viewmodels.ShoesListViewModelHelper
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        Timber.plant(Timber.DebugTree())

        ShoesListViewModelHelper.generateDummyData(this, 10)

        //setHasOptionsMenu(true)
        // Only for tracing
        ShoesListViewModelHelper.traceViewModel(this)

        setSupportActionBar(binding.toolbar)
        val navController = findNavController(R.id.myNavHostFragment)
        val config = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, config)
    }


}
