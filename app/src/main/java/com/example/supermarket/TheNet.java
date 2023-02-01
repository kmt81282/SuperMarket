package com.example.supermarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TheNet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_net);
        initReturnButton();
        Intent intent = getIntent();
        String nameSentFromRatings = intent.getStringExtra("namekey");
    }



    private void initReturnButton() {
        Button backbutton = findViewById(R.id.buttonReturnFromNet);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String nameSentFromRatings = intent.getStringExtra("namekey");
                Intent intent2 = new Intent(TheNet.this, RatingsActivity.class);
                intent2.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent2.putExtra("namekey",nameSentFromRatings);
                startActivity(intent2);
            }
        });
    }





}

