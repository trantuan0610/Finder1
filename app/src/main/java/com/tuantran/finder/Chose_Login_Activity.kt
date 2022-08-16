package com.tuantran.finder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.tuantran.finder.fragment.*
import kotlinx.android.synthetic.main.activity_chose_login.*


class Chose_Login_Activity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chose_login)
        tvLoginPhoneEmail.setOnClickListener {
            val intent : Intent = Intent(this,ChoseLogin_Phone_Email_Activity::class.java)
            startActivity(intent)
        }



    }

    override fun onStart() {
        super.onStart()

    }


}