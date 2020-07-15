package com.softsquared.examplesharedpreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SharedPreferenceActivity extends AppCompatActivity {

    Button mBtnAdjust;
    EditText mEdtTitle,mEdtContents;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpreference);

        mEdtTitle=findViewById(R.id.sp_edt_title);
        mEdtContents=findViewById(R.id.sp_edt_contents);

        mBtnAdjust=findViewById(R.id.sp_btn_adjustment);
        mBtnAdjust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences =getSharedPreferences("memo",MODE_PRIVATE);
                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putString("title",mEdtTitle.getText().toString());
                editor.putString("contents",mEdtContents.getText().toString());
                editor.apply(); // 꼭 해야 됩니다.
                finish();
            }
        });
    }
}
