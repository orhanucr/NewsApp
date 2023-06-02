package com.example.orhan_ucar_odev4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)
        val result = Result()

        Thread {
            val list = result.news()
            Log.d("title", list[0].href)
            runOnUiThread {
                val adapter = NewsListAdapter(this, R.layout.item_layout, list)
                listView.adapter = adapter

                listView.setOnItemClickListener { parent, view, position, id ->
                    val news = list[position]
                    val intent = Intent(this, WebViewActivity::class.java)
                    intent.putExtra("url", news.href)
                    startActivity(intent)
                }
            }
        }.start()
    }
}