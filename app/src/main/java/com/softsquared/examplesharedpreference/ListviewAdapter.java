package com.softsquared.examplesharedpreference;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListviewAdapter extends BaseAdapter {

    ArrayList<Data> mArrayList;
    Context mContext;
    LayoutInflater mLayoutInflater;
    TextView mTitle,mContents;

    public ListviewAdapter(ArrayList<Data> mArrayList, Context mContext) {
        this.mArrayList = mArrayList;
        this.mContext = mContext;
        mLayoutInflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Data getItem(int position) {

        return mArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        view= mLayoutInflater.inflate(R.layout.item_layout,parent,false);
        mTitle=view.findViewById(R.id.item_layout_title);
        mContents=view.findViewById(R.id.item_layout_contents);

        mTitle.setText(mArrayList.get(position).getTitle());
        mContents.setText(mArrayList.get(position).getContents());
        return view;
    }
}
