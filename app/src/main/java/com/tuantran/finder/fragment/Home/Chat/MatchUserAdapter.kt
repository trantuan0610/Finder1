package com.tuantran.finder.fragment.Home.Chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tuantran.finder.R
import de.hdodenhof.circleimageview.CircleImageView

class MatchUserAdapter(private val usersList : ArrayList<Users>) : RecyclerView.Adapter<MatchUserAdapter.MyViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =  LayoutInflater.from(parent.context).inflate(R.layout.matched_user_item,parent,false)
        return MatchUserAdapter.MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val users = usersList[position]
        holder.imageView.setImageResource(users.profileImageUrl)
        holder.name.text = users.name
        holder.bio.text = users.bio

    }

    override fun getItemCount(): Int { return  usersList.size    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView : CircleImageView = itemView.findViewById(R.id.mui_image)
        val name : TextView = itemView.findViewById(R.id.mui_name)
        val bio : TextView = itemView.findViewById(R.id.mui_bio)
    }

}