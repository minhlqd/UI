package com.example.activityrecyclerview.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.activityrecyclerview.NewsItem
import com.example.activityrecyclerview.R
import com.example.activityrecyclerview.uis.HomeActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_news_article.*

class NewsArticleFragment : Fragment() {
    var newsFragment: NewsFragment = NewsFragment()
    lateinit var homeActivity : HomeActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news_article, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle: Bundle = this.arguments!!
        val name: String? = bundle.getString("name")
        news.text = name
        back.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragmentMain, NewsFragment())?.commit()
        }
    }

}