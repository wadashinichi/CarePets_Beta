package com.example.carepets_beta.maincontent

import android.os.Bundle
import android.widget.TableLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager.widget.ViewPager
import com.example.carepets_beta.R
import com.example.carepets_beta.databinding.ActivityMainComponentBinding
import com.example.carepets_beta.maincontent.medicalbook.SectionsPagerAdapter

//import com.example.carepets_beta.maincontent.databinding.ActivityMainComponentBinding

class MainComponentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainComponentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainComponentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main_component)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // tab
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabLayout: TableLayout = binding.tabLayout
        tabLayout.setupWithViewPager(viewPager)
    }
}