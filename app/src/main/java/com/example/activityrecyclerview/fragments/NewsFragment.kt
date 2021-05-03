package com.example.activityrecyclerview.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.activityrecyclerview.R
import com.example.activityrecyclerview.adaters.IndexAdapter
import com.example.activityrecyclerview.adaters.NewAdapter
import com.example.activityrecyclerview.adaters.NewSwipeToDelete
import com.example.activityrecyclerview.adaters.SwipeToDelete
import com.example.activityrecyclerview.data.Index
import com.example.activityrecyclerview.data.New
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_news.bottom_navigation
import kotlinx.android.synthetic.main.fragment_home.recycleView
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : Fragment() {
    lateinit var new : MutableList<New>
    lateinit var newAdapter: NewAdapter
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
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
        newAdapter= NewAdapter(new)
        recycleView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        recycleView.layoutManager = layoutManager
        recycleView.adapter = newAdapter

        val itemTouchHelper = ItemTouchHelper(NewSwipeToDelete(newAdapter))
        itemTouchHelper.attachToRecyclerView(recycleView)

        val navController : NavController = Navigation.findNavController(view)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> navController.navigate(R.id.action_newsFragment_to_homeFragment)
                R.id.coin -> navController.navigate(R.id.action_newsFragment_to_coinFragment)
                else -> navController.navigate(R.id.action_newsFragment_to_customerFragment)
            }
            true
        }
    }
}