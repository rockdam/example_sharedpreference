package com.softsquared.examplesharedpreference

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.util.*

class ListviewAdapter(var mArrayList: ArrayList<Data>, var mContext: Context) : BaseAdapter() {
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

    override fun getView(position: Int, view: View, parent: ViewGroup): View {
        var view = view
        view = mLayoutInflater.inflate(R.layout.item_layout, parent, false)
        mTitle = view.findViewById(R.id.item_layout_title)
        mContents = view.findViewById(R.id.item_layout_contents)

        mTitle?.text=mArrayList[position].title
        mContents?.text=mArrayList[position].contents
        return view
    }

    init {
        mLayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }
}