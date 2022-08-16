package com.tuantran.finder.fragment.Settings

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import com.tuantran.finder.Chose_Login_Activity
import com.tuantran.finder.R
import kotlinx.android.synthetic.main.fragment_settings.*


class SettingsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnLogout.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            var intent : Intent
            intent = Intent(activity,Chose_Login_Activity::class.java)
            startActivity(intent)
            

        }
    }


}