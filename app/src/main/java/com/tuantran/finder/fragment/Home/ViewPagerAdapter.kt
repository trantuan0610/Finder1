package com.tuantran.finder.fragment.Home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.tuantran.finder.fragment.Home.Chat.ChatFragment
import com.tuantran.finder.fragment.Home.Finder.FinderFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        when (position){
            0 ->  FinderFragment()
            1-> ChatFragment()
            2-> FavoriteFragment()
            3-> ProfileFragment()
        }
        return FinderFragment()
    }
}