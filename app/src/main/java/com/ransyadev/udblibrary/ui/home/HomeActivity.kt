package com.ransyadev.udblibrary.ui.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
import com.ransyadev.udblibrary.R
import com.ransyadev.udblibrary.databinding.ActivityHomeBinding
import com.ransyadev.udblibrary.ui.cart.CartFragment
import com.ransyadev.udblibrary.ui.history.HistoryFragment
import com.ransyadev.udblibrary.ui.profile.ProfileFragment
import com.ransyadev.udblibrary.utils.gone
import com.ransyadev.udblibrary.utils.hideKeyboard
import com.ransyadev.udblibrary.utils.showToast
import com.ransyadev.udblibrary.utils.visible

class HomeActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener{
    private lateinit var binding : ActivityHomeBinding
    private var isExit = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.sivProfile.setOnClickListener {
            hideKeyboard()
            binding.bottomNavigation.selectedItemId = R.id.nav_profile
            selectActiveTabs(R.id.nav_profile)
        }

        binding.bottomNavigation.setOnItemSelectedListener(this)
        selectActiveTabs(binding.bottomNavigation.selectedItemId)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        selectActiveTabs(itemId = item.itemId)
        return true
    }

    private fun selectActiveTabs(itemId: Int) {
        when(itemId){
            R.id.nav_cart -> {
                binding.clToolbar.gone()
                loadFragment(fragment = CartFragment())
            }
            R.id.nav_history -> {
                binding.clToolbar.gone()
                loadFragment(fragment = HistoryFragment())
            }
            R.id.nav_profile -> {
                binding.clToolbar.gone()
                loadFragment(fragment = ProfileFragment())
            }
            R.id.nav_home -> {
                loadFragment(fragment = HomeFragment())
                binding.clToolbar.visible()
            }
        }
    }

    private fun loadFragment(fragment : Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_container, fragment)
            .commit()
    }

    override fun onBackPressed() {
        if (isExit) {
            super.onBackPressed()
            finishAffinity()
        } else {
            isExit = true
            showToast("Tekan sekali lagi untuk keluar aplikasi")
        }
        Handler(Looper.getMainLooper()).postDelayed({ isExit = false }, 2000)
    }

}
