package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myapplication.ui.category.CategoryFragment
import com.example.myapplication.ui.favorite.FavoriteFragment
import com.example.myapplication.ui.product.ProductFragment
import com.example.myapplication.ui.search.SearchFragment
import com.example.myapplication.ui.user.UserFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavMenu()
    }

    private fun bottomNavMenu() {
        bottom_nav_menu.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.product_unit -> {
                    loadFragment(ProductFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.category -> {
                    loadFragment(CategoryFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.favorite -> {
                    loadFragment(FavoriteFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.search -> {
                    loadFragment(SearchFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.user -> {
                    loadFragment(UserFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentTransaction, fragment)
            .commit()
    }
}