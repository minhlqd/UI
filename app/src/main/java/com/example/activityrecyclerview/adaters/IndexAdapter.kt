package com.example.activityrecyclerview.adaters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.activityrecyclerview.R
import com.example.activityrecyclerview.data.Index
import com.example.activityrecyclerview.uis.HomeActivity

class IndexAdapter(var indexList: MutableList<Index>) : RecyclerView.Adapter<IndexAdapter.IndexViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IndexViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return IndexViewHolder(inflater.inflate(R.layout.index_item, parent, false))
    }

    class IndexViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name : TextView = itemView.findViewById(R.id.name)
        private val city : TextView = itemView.findViewById(R.id.city)

        fun bindData(index : Index) {
            name.text = index.name
            city.text = index.city
        }
    }

    fun deleteItem(pos : Int)
    {
        indexList.removeAt(pos)
        notifyItemRemoved(pos)
    }

    override fun onBindViewHolder(holder: IndexViewHolder, position: Int) {
        holder.bindData(indexList?.get(position))
    }

    override fun getItemCount(): Int = indexList.size
}
