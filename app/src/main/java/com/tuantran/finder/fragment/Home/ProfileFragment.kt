package com.tuantran.finder.fragment.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentTransaction
import com.tuantran.finder.R
import com.tuantran.finder.fragment.Settings.Edit_Profile_Fragment
import com.tuantran.finder.fragment.Settings.SettingsFragment


class ProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile,container,false)



        return view
}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnSetting = view.findViewById<ImageView>(R.id.img_settings)
        btnSetting.setOnClickListener{
            var another = SettingsFragment()
            var transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.fragment,another)
            transaction.commit()

        }
        val btnEdit = view.findViewById<ImageView>(R.id.img_edit_info)
        btnEdit.setOnClickListener{
            var another = Edit_Profile_Fragment()
            var transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.fragment,another)
            transaction.commit()

        }

    }





    }
