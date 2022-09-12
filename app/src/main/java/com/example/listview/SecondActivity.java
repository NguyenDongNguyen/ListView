package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView txtMonHoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtMonHoc = (TextView) findViewById(R.id.textViewSecond);
        Intent intent = getIntent();
        String noiDung = intent.getStringExtra("monhoc");
        txtMonHoc.setText(noiDung);
    }
}