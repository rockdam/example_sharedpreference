package com.softsquared.examplesharedpreference

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.util.*
import kotlinx.android.synthetic.main.item_layout.view.*

class ListviewAdapter(var mArrayList: ArrayList<Data>,mContext: Context) : BaseAdapter() {
    var mLayoutInflater: LayoutInflater
    var mTitle: TextView? = null
    var mContents: TextView? = null
    override fun getCount(): Int {
        return mArrayList.size
    }

    override fun getItem(position: Int): Data {
        return mArrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var view = view
        view = mLayoutInflater.inflate(R.layout.item_layout, parent, false)

        view.item_layout_title.text=mArrayList[position].title
        view.item_layout_contents.text=mArrayList[position].contents
        return view
    }

    init {
        mLayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }
}