package com.example.movies.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_basic.view.*


// loads image into item view
class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: String) {
        Glide.with(itemView.context).load(item)
            .centerCrop()
            .into(itemView.basicImageView)
    }

    
}