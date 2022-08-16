package com.tuantran.finder.fragment.Home.Chat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tuantran.finder.R
import de.hdodenhof.circleimageview.CircleImageView

class ActiveUserAdapter(private val usersList : ArrayList<Users>) : RecyclerView.Adapter<ActiveUserAdapter.MyViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =  LayoutInflater.from(parent.context).inflate(R.layout.active_user_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
                val users = usersList[position]
                holder.imageView.setImageResource(users.profileImageUrl)
                holder.name.text = users.name
            }

    override fun getItemCount(): Int {
        return usersList.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


        val imageView : CircleImageView = itemView.findViewById(R.id.aui_image)
        val name : TextView = itemView.findViewById(R.id.aui_name)






    }

}