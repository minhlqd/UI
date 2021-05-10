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

    private var context: HomeActivity? = null
    private val layout = 0

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









//package com.example.activityrecyclerview.adaters
//
//import android.annotation.SuppressLint
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.activityrecyclerview.R
//import com.example.activityrecyclerview.data.Index
//import com.example.activityrecyclerview.uis.HomeActivity
//
//class IndexAdapter(private var indexList: MutableList<Index>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//
//    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
//        val inflater = LayoutInflater.from(p0.context)
//        return when (p1) {
//            ViewType.TYPE_ONE.type -> {
//                val view = inflater.inflate(R.layout.index_item, p0, false)
//                IndexViewHolder(view)
//            }
//            else -> {
//                val view = inflater.inflate(R.layout.load_more, p0, false)
//                LoadMoreViewHolder(view)
//            }
//        }
//    }
//    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
//        p0.apply {
//            when(p0){
//                is IndexViewHolder -> {
//                    p0.bindData(indexList[p1])
//                }
//                is LoadMoreViewHolder -> {
//                    p0.bindData()
//                }
//            }
//        }
//    }
//
//    override fun getItemViewType(position: Int): Int {
//        return when(indexList[position]) {
//            null -> ViewTypeIndex.TYPE_TWO.type
//            else -> ViewTypeIndex.TYPE_ONE.type
//        }
//    }
//    override fun getItemCount(): Int = indexList.size
//
//    inner class IndexViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        private val name : TextView = view.findViewById(R.id.name)
//        private val city : TextView = view.findViewById(R.id.city)
//
//        fun bindData(index : Index) {
//            name.text = index.name
//            city.text = index.city
//        }
//    }
//    inner class LoadMoreViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        private val button : TextView = view.findViewById(R.id.loadMore)
//
//        @SuppressLint("SetTextI18n")
//        fun bindData() {
//            button.text = "Load More"
//        }
//    }
//
//    fun deleteItem(pos : Int)
//    {
//        indexList.removeAt(pos)
//        notifyItemRemoved(pos)
//    }
//}
//enum class ViewTypeIndex(val type: Int) {
//    TYPE_ONE(0),
//    TYPE_TWO(1)
//}
