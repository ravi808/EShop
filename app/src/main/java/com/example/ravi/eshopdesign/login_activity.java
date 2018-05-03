package com.example.ravi.eshopdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login_activity extends AppCompatActivity {
/*    Button login_btn;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        /*login_btn = findViewById(R.id.register);*/
    }

    public void login_btn(View v){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
