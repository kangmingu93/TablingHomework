package com.crayon.tablinghomework.presentation

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.crayon.tablinghomework.R
import com.crayon.tablinghomework.databinding.ActivityMainBinding
import com.crayon.tablinghomework.presentation.navigation.setupWithNavController
import dagger.android.support.DaggerAppCompatActivity
import android.view.MenuItem

import android.view.Menu
import androidx.core.view.get


class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentNavController: LiveData<NavController>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            setUpBottomNavigationBar()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setUpBottomNavigationBar()
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }

    private fun setUpBottomNavigationBar() {
        val navGraphIds = listOf(
            R.navigation.navigation_home,
            R.navigation.navigation_search,
            R.navigation.navigation_store_interest,
            R.navigation.navigation_my,
        )
        val controller = binding.bottomNavigation.setupWithNavController(
            navGraphIds,
            supportFragmentManager,
            R.id.nav_host_fragment_container,
            intent
        )
        currentNavController = controller

        // 시작을 관심매장 화면으로...
        binding.bottomNavigation.selectedItemId = R.id.nav_store_interest
    }

}