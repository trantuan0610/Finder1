package com.tuantran.finder.fragment.Home.Chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tuantran.finder.R
import com.tuantran.finder.databinding.FragmentChatBinding


class ChatFragment : Fragment() {

    private lateinit var binding : FragmentChatBinding
    private lateinit var newArrayList: ArrayList<Users>
    lateinit var imageID : Array<Int>
    lateinit var heading : Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentChatBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageID = arrayOf(R.drawable.imgdaidien
            ,R.drawable.imgdaidien
            ,R.drawable.imgdaidien
            ,R.drawable.imgdaidien
            ,R.drawable.imgdaidien
            ,R.drawable.imgdaidien
            ,R.drawable.imgdaidien)
        heading = arrayOf("Tuấn Trần"
        ,"Tuấn Trần"
        ,"Tuấn Trần"
        ,"Tuấn Trần"
        ,"Tuấn Trần"
        ,"Tuấn Trần"
            ,"Tuấn Trần")

        binding.rcv1.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        binding.rcv1.setHasFixedSize(true)

        binding.rcv2.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        binding.rcv2.setHasFixedSize(true)

        newArrayList = arrayListOf<Users>()
        getUserdata()




    }

    private fun getUserdata() {
        for(i in imageID.indices){
            val users = Users(i,heading[i],21,imageID[i],"Hey Babe come here with me hihi","",0)
            newArrayList.add(users)
        }

        binding.rcv1.adapter = ActiveUserAdapter(newArrayList)
        binding.rcv2.adapter = MatchUserAdapter(newArrayList)
    }


}
