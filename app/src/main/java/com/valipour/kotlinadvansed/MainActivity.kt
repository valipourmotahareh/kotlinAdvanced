package com.valipour.kotlinadvansed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.valipour.kotlinadvansed.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        setUpNavigationComponent();
    }

    private fun setUpNavigationComponent(){
        val navHostFragment:NavHostFragment= supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController=navHostFragment.navController
        AppBarConfiguration.Builder(setOf(R.id.homeFragment,R.id.planFragment)).setOpenableLayout(
            binding.drawerLayout).build()
        binding.navView.setupWithNavController(navController)
        val popupMenu= PopupMenu(this,null)
        popupMenu.inflate(R.menu.menu_bottom)
        val menu=popupMenu.menu
        binding.bottomBar.setupWithNavController(menu,navController)

    }
}