package com.p7k.retrofit2homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.p7k.retrofit2homework.adapter.NewsAdapter
import com.p7k.retrofit2homework.api.NewApiInterface
import com.p7k.retrofit2homework.model.Article
import com.p7k.retrofit2homework.model.News
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            getNews()
    }

    fun getNews() {
        var BASE_URL = "http://newsapi.org/v2/"
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var retrofitService = retrofit.create(NewApiInterface::class.java)

        var apiCall =
            retrofitService.getNews("us", "business", "d1f97d6073ba49f48370ba44fb2c2384")
        apiCall.enqueue(object : Callback<News> {
            override fun onFailure(call: Call<News>, t: Throwable) {

            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                var list = response.body()?.articles
                Log.d("Article>>>>", list.toString())
                val newsAdapter = NewsAdapter(list as List<Article>)
                recyclerNew.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = newsAdapter
                }
            }
        })

    }


}
