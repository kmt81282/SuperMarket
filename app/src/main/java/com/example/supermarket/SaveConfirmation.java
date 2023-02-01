package com.example.supermarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SaveConfirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_confirmation);
        initReturnButton();

        Intent intent = getIntent();
        String sentFromRatingName = intent.getStringExtra("namekey");
        String sentFromRatingScore = intent.getStringExtra("overallkey");

        TextView message = findViewById(R.id.textSaveAndRating);
        Resources res = getResources();
        String displayMessage = res.getString(R.string.final_save,sentFromRatingName,sentFromRatingScore);
        message.setText(displayMessage);

    }

    private void initReturnButton() {
        Button savebutton = findViewById(R.id.buttonReturnToMain);
        savebutton.setOnClickListener(new View.OnClickListener() {
            Intent intent = getIntent();
            String sentFromRatingName = intent.getStringExtra("namekey");
            String sentFromRatingScore = intent.getStringExtra("overallkey");

            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(SaveConfirmation.this,MainActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent2.putExtra("namekey", sentFromRatingName);
                intent2.putExtra("overallkey", sentFromRatingScore);
                startActivity(intent2);
            }
        });
    }



}