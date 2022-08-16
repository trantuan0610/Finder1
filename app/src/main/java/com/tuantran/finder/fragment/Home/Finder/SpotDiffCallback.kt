package com.tuantran.finder.fragment.Home.Finder

import androidx.recyclerview.widget.DiffUtil

class SpotDiffCallback(private val old: List<User>, private val new: List<User>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return old.size
    }

    override fun getNewListSize(): Int {
        return new.size
    }

    override fun areItemsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return old[oldPosition].age == new[newPosition].age
    }

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return old[oldPosition] == new[newPosition]
    }

}
