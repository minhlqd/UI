package com.example.activityrecyclerview.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.activityrecyclerview.NewsItem
import com.example.activityrecyclerview.R
import kotlinx.android.synthetic.main.fragment_news_article.*

class NewsArticleFragment : Fragment() {
    var newsFragment: NewsFragment = NewsFragment()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_article, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        back.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragmentMain, NewsFragment())?.commit()
        }
    }

}