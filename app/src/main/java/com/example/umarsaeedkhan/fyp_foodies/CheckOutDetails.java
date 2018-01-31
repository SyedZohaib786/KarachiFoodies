package com.example.umarsaeedkhan.fyp_foodies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheckOutDetails extends AppCompatActivity {
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out_details);


        bt = (Button) findViewById(R.id.btnPlaceMoreOders);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(CheckOutDetails.this, MainScreen.class);
                startActivity(in);
            }
        });

    }
}
