package com.example.favchar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView left;
    ImageView right;
    int l = 0;
    int r = 1;
    int fav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("FavouriteCharacter");
        actionBar.setDisplayShowHomeEnabled(true);
        left = findViewById(R.id.left);
        right = findViewById(R.id.right);
        ArrayList<Integer> resourceIds = new ArrayList<>();
        String charNames[] = getResources().getStringArray(R.array.Char_names);
        for(String charname : charNames){
            System.out.println(charname);
            resourceIds.add(getResources().getIdentifier(charname,"drawable","com.example.favchar"));
        }
        for(int j = 0;j<resourceIds.size();j++){
            System.out.println(resourceIds.get(j));
        }
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fav = l;
                if(l<r){
                    r++;
                }
                else{
                    r = l+1;
                }
                if(r<resourceIds.size())
                right.setImageResource((int)resourceIds.get(r));
                else{
                    Intent intent = new Intent(getApplicationContext(), Favourite.class);
                    intent.putExtra("resourceID",resourceIds.get(l));
                    intent.putExtra("nameIndex",l);
                    l = 0;r = 1;
                    startActivity(intent);
                }
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fav = r;
                if(r<l){
                    l++;
                }
                else{
                    l = r+1;
                }
                if(l<resourceIds.size())
                left.setImageResource((int)resourceIds.get(l));
                else{
                    Intent intent = new Intent(getApplicationContext(), Favourite.class);
                    intent.putExtra("resourceID",resourceIds.get(r));
                    System.out.println("from the array:"+resourceIds.get(r));
                    System.out.println("the actual thing:"+R.drawable.al_haitham);
                    intent.putExtra("nameIndex",r);
                    l = 0;r = 1;
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}