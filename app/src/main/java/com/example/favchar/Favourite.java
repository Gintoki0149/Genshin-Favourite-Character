package com.example.favchar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Favourite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        TextView name = findViewById(R.id.Name);
        Intent intent = getIntent();
        int resId = intent.getIntExtra("resourceID",0);
        int nameIndex = intent.getIntExtra("nameIndex",0);
        String arr[] = getResources().getStringArray(R.array.Char_names);
        String charname = arr[nameIndex];
        name.setText(charname);
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(resId);
    }
}