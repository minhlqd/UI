package com.example.activityrecyclerview.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.activityrecyclerview.NewsItem
import com.example.activityrecyclerview.R
import com.example.activityrecyclerview.adaters.NewAdapter
import com.example.activityrecyclerview.NewSwipeToDelete
import com.example.activityrecyclerview.data.New
import com.example.activityrecyclerview.uis.HomeActivity
import kotlinx.android.synthetic.main.fragment_home.recycleView
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.android.synthetic.main.new_item.*

class NewsFragment : Fragment(),NewsItem {
    private lateinit var new : MutableList<New>
    private lateinit var newAdapter: NewAdapter
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var text: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        new = mutableListOf()
        for (i in 0..10) {
            val drawable = when (i%3) {
                0 -> R.drawable.ic_atlanta
                1 -> R.drawable.xiaomi
                else -> R.drawable.ic_apple
            }
            val name = when (i%3) {
                0 -> "Atlanta"
                1 -> "Xiaomi"
                else -> "Apple"
            }
            val item = New(drawable, name)
            new.add(item)
        }
        newAdapter= NewAdapter(new,this, context as HomeActivity)
        recycleView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        recycleView.layoutManager = layoutManager
        recycleView.adapter = newAdapter

        val itemTouchHelper = ItemTouchHelper(NewSwipeToDelete(newAdapter))
        itemTouchHelper.attachToRecyclerView(recycleView)
        back.setOnClickListener {
            fragmentManager?.popBackStack()
        }
    }

    override fun onItemClick(name: String) {
        nameItem.text = name

        Log.d("aaa", name)
    }
}