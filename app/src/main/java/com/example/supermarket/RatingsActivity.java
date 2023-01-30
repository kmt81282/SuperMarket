package com.example.supermarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class RatingsActivity extends AppCompatActivity {

    //RatingBar liquorRatingBar, produceRatingBar, meatRatingBar, cheeseRatingBar, checkoutRatingBar;
    private Rating currentRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);

        initSaveRatingButton();

        currentRating = new Rating();

    }

    private void initSaveRatingButton() {
        ImageButton saveButton = findViewById(R.id.buttonSave);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean wasSuccessful = true;
                RatingDataSource ds = new RatingDataSource(RatingsActivity.this);
                try {
                    ds.open();

                    if (currentRating.getSuperMarketID() == -1) {

                        wasSuccessful = ds.insertRating(currentRating);
                        if (wasSuccessful) {

                            int newID = ds.getLastMarketID();
                            currentRating.setSuperMarketID(newID);
                        }
                    } else {
                        wasSuccessful = ds.updateContact(currentRating);
                    }
                    ds.close();
                }
                catch (Exception e) {
                    wasSuccessful = false;
                    TextView textError = findViewById(R.id.textName);
                    Resources res = getResources();
                    String displayError = res.getString(R.string.error);
                    textError.setText(displayError);

                }
                if (wasSuccessful) {
                    TextView textError = findViewById(R.id.textName);
                    Resources res = getResources();
                    String displayError = res.getString(R.string.saved);
                    textError.setText(displayError);
                }
            }
        });
    }



}


