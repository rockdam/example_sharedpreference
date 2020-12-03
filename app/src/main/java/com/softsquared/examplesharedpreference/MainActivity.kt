package com.softsquared.examplesharedpreference

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var mListview: ListView? = null
    var mListviewAdapter: ListviewAdapter? = null
    var mArrayList = ArrayList<Data>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mListview = findViewById(R.id.main_listview)
        mListviewAdapter = ListviewAdapter(mArrayList, this)
        mArrayList.add(Data("rock", "awesome"))
        mArrayList.add(Data("rock", "zzang"))
        mListview?.adapter=mListviewAdapter

        main_btn_create.setOnClickListener(this)
        main_btn_inqury.setOnClickListener(this)

//        ?. 연산자를 사용하면, 앞의 변수가 null이 아닐때만 오른쪽 함수가 수행되고 null이면 null을 반환합니다.
//
//출처: https://tourspace.tistory.com/114 [투덜이의 리얼 블로그]
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.main_btn_create -> {
                val intent = Intent(this@MainActivity, SharedPreferenceActivity::class.java)
                startActivity(intent)
            }
            R.id.main_btn_inqury -> {
                mArrayList.clear()
                val sharedPreferences = getSharedPreferences("memo", MODE_PRIVATE)
                mArrayList.add(Data(sharedPreferences.getString("title", "")!!, sharedPreferences.getString("contents", "")!!))
                mListviewAdapter!!.notifyDataSetChanged()
            }
        }
    }
}