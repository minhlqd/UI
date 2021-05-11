package com.example.activityrecyclerview.adaters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.activityrecyclerview.R
import com.example.activityrecyclerview.data.Customer
import kotlinx.android.synthetic.main.customer_item_1.view.*
import kotlinx.android.synthetic.main.customer_item_2.view.*
import kotlinx.android.synthetic.main.customer_item_3.view.*
import kotlinx.android.synthetic.main.customer_item_4.view.*

class CustomerAdapter(
    private var customerItem1 : MutableList<Customer>,
    private var customerItem2: MutableList<Customer>,
    private var customerItem3: MutableList<Customer>,
    private var customerItem4: MutableList<Customer>,
    private var customerItem5: MutableList<Customer>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(p0.context)
        return when (p1) {
            ViewType.TYPE_ONE.type -> {
                val view = inflater.inflate(R.layout.customer_item_1, p0, false)
                TypeOneViewHolder(view)
            }
            ViewType.TYPE_TWO.type -> {
                val view = inflater.inflate(R.layout.customer_item_2, p0, false)
                TypeTwoViewHolder(view)
            }
            ViewType.TYPE_THREE.type -> {
                val view = inflater.inflate(R.layout.customer_item_3, p0, false)
                TypeThreeViewHolder(view)
            }
            ViewType.TYPE_FOUR.type -> {
                val view = inflater.inflate(R.layout.customer_item_4, p0, false)
                TypeFourViewHolder(view)
            }
            else -> {
                val view = inflater.inflate(R.layout.customer_item_2, p0, false)
                TypeFiveViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        p0.apply {
            when (p0) {
                is TypeOneViewHolder -> {
                    p0.bind(customerItem1[p1])
                }
                is TypeThreeViewHolder -> {
                    p0.bind(customerItem3[p1 - 4])
                }
                is TypeTwoViewHolder -> {
                    p0.bind(customerItem2[p1 - 5])
                }
                is TypeFourViewHolder -> {
                    p0.bind(customerItem4[p1 - 9])
                    Log.d("aaa",p1.toString())
                }
                is TypeFiveViewHolder -> {
                    p0.bind(customerItem5[p1 - 10])
                }
            }
        }
    }
    override fun getItemCount(): Int {
        return customerItem1.count() + customerItem2.count() + customerItem3.count() + customerItem4.count() + customerItem5.count()
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            in 0..3 -> ViewType.TYPE_ONE.type
            4 -> ViewType.TYPE_THREE.type
            in 5..8 -> ViewType.TYPE_TWO.type
            9 -> ViewType.TYPE_FOUR.type
            else -> ViewType.TYPE_FIVE.type
        }
    }
    inner class TypeOneViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtName1 : TextView = itemView.name1
        private val img1 : ImageView = itemView.image1
        fun bind(item: Customer) {
            txtName1.text = item.name
            img1.setImageResource(item.image)
        }
    }

    inner class TypeTwoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtName2 : TextView = itemView.name2
        private val img2 : ImageView = itemView.image2
        fun bind(item: Customer) {
            txtName2.text = item.name
            img2.setImageResource(item.image)
        }
    }
    inner class TypeThreeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtName3 : TextView = itemView.tools
        fun bind(item: Customer) {
            txtName3.text = item.name
        }
    }
    inner class TypeFourViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtName4 : TextView = itemView.markets
        fun bind(item: Customer) {
            txtName4.text = item.name
        }
    }
    inner class TypeFiveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtName5 : TextView = itemView.name2
        private val img5 : ImageView = itemView.image2
        fun bind(item: Customer) {
            txtName5.text = item.name
            img5.setImageResource(item.image)
        }
    }

}
enum class ViewType(val type: Int) {
    TYPE_ONE(0),
    TYPE_TWO(1),
    TYPE_THREE(2),
    TYPE_FOUR(3),
    TYPE_FIVE(4)
}