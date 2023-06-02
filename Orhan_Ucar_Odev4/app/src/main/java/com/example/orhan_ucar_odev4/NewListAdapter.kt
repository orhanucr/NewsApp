package com.example.orhan_ucar_odev4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class NewsListAdapter(context: Context, private val resource: Int, private val items: List<News>) :
    ArrayAdapter<News>(context, resource, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView

        if (itemView == null) {
            val inflater = LayoutInflater.from(context)
            itemView = inflater.inflate(resource, parent, false)
        }

        val newsImage = itemView!!.findViewById<ImageView>(R.id.news_image)
        val newsTitle = itemView.findViewById<TextView>(R.id.news_title)

        val item = items[position]

        Picasso.get().load(item.img).into(newsImage)
        newsTitle.text = item.title

        return itemView
    }
}
