package com.tuantran.finder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tuantran.finder.fragment.Home.Chat.ChatFragment
import com.tuantran.finder.fragment.Home.FavoriteFragment
import com.tuantran.finder.fragment.Home.Finder.FinderFragment
import com.tuantran.finder.fragment.Home.ProfileFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val finderFragment = FinderFragment()
        val favoriteFragment = FavoriteFragment()
        val chatFragment = ChatFragment()
        val profileFragment = ProfileFragment()

        val bottomNavigationView =findViewById<BottomNavigationView>(R.id.bottom_navi)
        setThatFragment(finderFragment)
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menu_finder -> setThatFragment(finderFragment)
                R.id.menu_favorite -> setThatFragment(favoriteFragment)
                R.id.menu_chat -> setThatFragment(chatFragment)
                R.id.menu_profile -> setThatFragment(profileFragment)
            }
            true
        }
    }


    private fun setThatFragment(fragment: Fragment) {
        if (fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment,fragment)
            transaction.commit()
        }
    }
}