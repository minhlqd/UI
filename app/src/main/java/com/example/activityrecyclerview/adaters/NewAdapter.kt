package com.example.activityrecyclerview.adaters

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.activityrecyclerview.NewsItem
import com.example.activityrecyclerview.R
import com.example.activityrecyclerview.data.New
import com.example.activityrecyclerview.fragments.NewsArticleFragment
import com.example.activityrecyclerview.fragments.NewsFragment
import com.example.activityrecyclerview.uis.HomeActivity
import kotlinx.android.synthetic.main.new_item.view.*

class NewAdapter(private var newList: MutableList<New>, private var onItemClick: NewsItem, var homeActivity: HomeActivity): RecyclerView.Adapter<NewAdapter.NewViewHolder>() {

    class NewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtName: TextView = itemView.nameItem
        var img: ImageView = itemView.img_name
        var newItem : RelativeLayout = itemView.newItem
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
        holder.newItem.setOnClickListener {
            onItemClick.onItemClick(newList?.get(position).name)
            homeActivity.supportFragmentManager.beginTransaction().replace(R.id.fragmentMain, NewsArticleFragment()).addToBackStack("Fragment").commit()
        }
    }

    override fun getItemCount(): Int  = newList.size
    fun deleteItem(pos: Int) {
        newList.removeAt(pos)
        notifyItemRemoved(pos)
    }

//    fun onItemMove(adapterPosition: Int, adapterPosition1: Int) {
//        val from
//
//    }

}