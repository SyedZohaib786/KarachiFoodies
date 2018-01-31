package com.example.umarsaeedkhan.fyp_foodies;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {
    private static int Screen_Time_Out = 3000;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        progressDialog = new ProgressDialog(SplashScreen.this);
        progressDialog.setMessage("Loading...");

        progressDialog.setCancelable(false);
        progressDialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);

            }
        }, Screen_Time_Out);
    }
}
