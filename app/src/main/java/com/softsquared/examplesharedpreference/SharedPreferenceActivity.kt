package com.softsquared.examplesharedpreference

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SharedPreferenceActivity : AppCompatActivity() {
    var mBtnAdjust: Button? = null
    var mEdtTitle: EditText? = null
    var mEdtContents: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sharedpreference)
        mEdtTitle = findViewById(R.id.sp_edt_title)
        mEdtContents = findViewById(R.id.sp_edt_contents)
        mBtnAdjust = findViewById(R.id.sp_btn_adjustment)

        mBtnAdjust?.setOnClickListener {
            val sharedPreferences = getSharedPreferences("memo", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("title", mEdtTitle?.text.toString())
            editor.putString("contents", mEdtContents?.text.toString())
            editor.apply() // 꼭 해야 됩니다.
            finish()
        }
    }
}