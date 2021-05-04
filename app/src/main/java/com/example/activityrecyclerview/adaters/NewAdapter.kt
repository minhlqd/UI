package com.example.activityrecyclerview.adaters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.activityrecyclerview.R
import com.example.activityrecyclerview.data.New
import kotlinx.android.synthetic.main.new_item.view.*

class NewAdapter(var newList: MutableList<New>): RecyclerView.Adapter<NewAdapter.NewViewHolder>() {

    class NewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtName: TextView = itemView.name
        var img: ImageView = itemView.img_name

        fun binData(new : New) {
            img.setImageResource(new.image)
            txtName.text = new.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NewViewHolder(inflater.inflate(R.layout.new_item, parent, false))
    }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
        holder.binData(newList?.get(position))
    }

    override fun getItemCount(): Int  = newList.size
    fun deleteItem(pos: Int) {
        newList.removeAt(pos)
        notifyItemRemoved(pos)
    }
}