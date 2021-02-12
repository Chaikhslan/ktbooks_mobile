package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.myapplication.ui.CategoryFragment
import com.example.myapplication.ui.FavoriteFragment
import com.example.myapplication.ui.ProductFragment
import com.example.myapplication.ui.UserFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavMenu()
    }

    private fun bottomNavMenu() {
        bottom_nav_menu.setOnNavigationItemReselectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.product_unit -> {
                    loadFragment(ProductFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.category -> {
                    loadFragment(CategoryFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.favorite -> {
                    loadFragment(FavoriteFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.user -> {
                    loadFragment(UserFragment())
                    return@setOnNavigationItemReselectedListener
                } else -> {
                    return@setOnNavigationItemReselectedListener
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().also { fragmentTransaction ->
            fragmentTransaction.replace(R.id.fragmentTransaction, fragment)
            fragmentTransaction.commit()
        }
    }
}