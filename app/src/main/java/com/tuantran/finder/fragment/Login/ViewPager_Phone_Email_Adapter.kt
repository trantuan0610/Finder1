package com.tuantran.finder.fragment.Login

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPager_Phone_Email_Adapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
       return  when(position){
           0-> Login_Phone_Fragment()
           1 -> Login_Email_Fragment()
           else -> throw Resources.NotFoundException("Possision is not found")
       }
    }
}