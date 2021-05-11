package com.example.activityrecyclerview.fragments

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.activityrecyclerview.R
import com.example.activityrecyclerview.adaters.IndexAdapter
import com.example.activityrecyclerview.SwipeToDelete
import com.example.activityrecyclerview.data.Index
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

@Suppress("DEPRECATION")
class HomeFragment : Fragment() {

    lateinit var index : MutableList<Index>
    lateinit var indexAdapter: IndexAdapter
    lateinit var layoutManager: LinearLayoutManager
    var touchHelper : ItemTouchHelper? = null


    private val index1: Index = Index("FTS100", "MADRID")
    private val index2: Index = Index("DAX", "XETRA")
    private val index3: Index = Index("DOWN JONE", "NYSE")
    private val index4: Index = Index("IBEX35", "LONDON")

    var data: Int = 2
    var isLoading : Boolean = false
    private val limit : Int = 10

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        index = mutableListOf()

        for (i in 1..10) {
            when (i) {
                in 1..5 -> index.add(index1)
                in 6..10 -> index.add(index2)
            }
        }
        //indexAdapter = IndexAdapter(index)
        recycleView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        recycleView.layoutManager = layoutManager
        //recycleView.adapter = indexAdapter
        getData()

        recycleView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy>0) {
                    val visibleItemCount = layoutManager.childCount
                    val pastVisibleItem = layoutManager.findFirstCompletelyVisibleItemPosition()
                    val total = indexAdapter.itemCount
                    if (!isLoading) {
                        if ((visibleItemCount + pastVisibleItem) >= total) {
                            data++
                            getData()
                        }
                    }
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })


        alarm.setOnClickListener {
            Toast.makeText(context, "alarm", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getData() {
        isLoading = true
//        progressBar.visibility = View.VISIBLE
        Log.d("aaa", isLoading.toString())
        loadMore.visibility = View.VISIBLE
        val start: Int = (data - 1) * limit
        val end: Int = data * limit
        for (i in start..end) {
            when (i%4) {
                0 -> index.add(index1)
                1 -> index.add(index2)
                2 -> index.add(index3)
                3 -> index.add(index4)
            }
        }
        Handler().postDelayed({
            Log.d("aaa", isLoading.toString())
            indexAdapter = IndexAdapter(index)
            recycleView.adapter = indexAdapter
            if (::indexAdapter.isInitialized) {
                indexAdapter.notifyDataSetChanged()
            }
//            if (::indexAdapter.isInitialized){
//                indexAdapter = IndexAdapter(index)
//                recycleView.adapter = indexAdapter
//                indexAdapter.notifyDataSetChanged()
//            } else {
//                Log.d("bbb", "View")
//                indexAdapter = IndexAdapter(index)
//                recycleView.adapter = indexAdapter
//            }
            val itemTouchHelper = ItemTouchHelper(SwipeToDelete(indexAdapter))
            itemTouchHelper.attachToRecyclerView(recycleView)
//            touchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.END, 0) {
//                override fun onMove(
//                    recyclerView: RecyclerView,
//                    viewHolder: RecyclerView.ViewHolder,
//                    target: RecyclerView.ViewHolder
//                ): Boolean {
//                    Collections.swap(index,viewHolder.adapterPosition,target.adapterPosition)
//                    indexAdapter.notifyItemMoved(viewHolder.adapterPosition, target.adapterPosition)
//                    return true
//                }
//
//                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//                    TODO("Not yet implemented")
//                }
//            })
//            touchHelper?.attachToRecyclerView(recycleView)

            isLoading = false
                //            progressBar.visibility = View.GONE
            loadMore.visibility = View.GONE
        }, 3000)
    }

}