package com.softsquared.examplesharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button mBtnCreate, mBtnInqury;
    ListView mListview;
    ListviewAdapter mListviewAdapter;
    ArrayList<Data> mArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListview = findViewById(R.id.main_listview);
        mListviewAdapter = new ListviewAdapter(mArrayList, this);
        mArrayList.add(new Data("rock", "awesome"));
        mArrayList.add(new Data("rock", "zzang"));
        mListview.setAdapter(mListviewAdapter);

        mBtnCreate = findViewById(R.id.main_btn_create);
        mBtnInqury = findViewById(R.id.main_btn_inqury);
        mBtnCreate.setOnClickListener(this);
        mBtnInqury.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_btn_create:

                Intent intent = new Intent(MainActivity.this, SharedPreferenceActivity.class);
                startActivity(intent);
                break;
            case R.id.main_btn_inqury:
                mArrayList.clear();
                SharedPreferences sharedPreferences = getSharedPreferences("memo", MODE_PRIVATE);
                mArrayList.add(new Data(sharedPreferences.getString("title", ""), sharedPreferences.getString("contents", "")));
                mListviewAdapter.notifyDataSetChanged();

                break;


        }

    }
}
