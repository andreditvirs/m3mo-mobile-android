package com.uwika.memo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void gotoNewMemo(View v){
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }

    public void gotoViewMemo(View v){
        Intent intent1 = new Intent(this, ViewActivity.class);
        startActivity(intent1);
    }

    public void gotoAbout(View v){
        Intent intent1 = new Intent(this, AboutActivity.class);
        startActivity(intent1);
    }
}