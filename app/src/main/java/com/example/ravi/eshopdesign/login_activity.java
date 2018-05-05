package com.example.ravi.eshopdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

public class login_activity extends AppCompatActivity {
/*    Button login_btn;*/

    LoginButton loginButton;
    CallbackManager callbackManager;

    private static final String EMAIL = "email";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        /*login_btn = findViewById(R.id.register);*/
        callbackManager = CallbackManager.Factory.create();


        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();


        loginButton = findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList(EMAIL));
        // If you are using in a fragment, call loginButton.setFragment(this);

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                Intent i = new Intent(login_activity.this,MainActivity.class);
                startActivity(i);
            }

            @Override
            public void onCancel() {
                Toast.makeText(login_activity.this, "Confirm Key Hash", Toast.LENGTH_SHORT).show();
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
                Toast.makeText(login_activity.this, "Configure Key Hash2", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void register_btn(View v){
        Intent i = new Intent(this,Registration.class);
        startActivity(i);
    }
}
