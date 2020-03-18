package com.p7k.retrofit2homework.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.p7k.retrofit2homework.R
import com.p7k.retrofit2homework.model.Article
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter (var articlelist: List<Article>):RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(){
    inner class NewsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bindArticle(article:Article){
            itemView.txtTitle.text=article.title
            itemView.txtContent.text=article.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
       var view=LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
      return articlelist.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bindArticle(articlelist[position])
    }
}