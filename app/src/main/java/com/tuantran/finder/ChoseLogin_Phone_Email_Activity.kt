package com.tuantran.finder

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.tuantran.finder.fragment.Login.ViewPager_Phone_Email_Adapter

class ChoseLogin_Phone_Email_Activity : AppCompatActivity() {

    private  lateinit var  tablayout : TabLayout
    private  lateinit var  viewPager2: ViewPager2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chose_login_phone_email)


        tablayout = findViewById(R.id.tablayout)
        viewPager2 = findViewById(R.id.viewpager2)
        viewPager2.adapter = ViewPager_Phone_Email_Adapter(this)
        TabLayoutMediator(tablayout,viewPager2){ tab,index ->
            tab.text = when(index){
                0 -> "Phone"
                1 ->"Email"
                else -> throw Resources.NotFoundException("Possion is not found")

            }


        }.attach()
    }
}