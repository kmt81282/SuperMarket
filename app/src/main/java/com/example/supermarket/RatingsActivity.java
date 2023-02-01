package com.example.supermarket;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class RatingsActivity extends AppCompatActivity {

    private Rating currentRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);
        initSaveRatingButton();
        initListButton();
        initCatButton();
        TextView receivedFromMain = findViewById(R.id.textName);
        Intent intent = getIntent();
        String sentFromMain = intent.getStringExtra("namekey");
        receivedFromMain.setText(sentFromMain);


        currentRating = new Rating();
    }


    private void initSaveRatingButton() {
        ImageButton saveButton = findViewById(R.id.buttonSave);
        Intent intent = getIntent();
        String sentFromMain = intent.getStringExtra("namekey");
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RatingBar liquor = findViewById(R.id.ratingBarLiquor);
                currentRating.setLiquorRating(liquor.getRating());
                RatingBar produce = findViewById(R.id.ratingBarProduce);
                currentRating.setProduceRating(produce.getRating());
                RatingBar meat = findViewById(R.id.ratingBarMeat);
                currentRating.setMeatRating(meat.getRating());
                RatingBar cheese = findViewById(R.id.ratingBarCheese);
                currentRating.setCheeseRating(cheese.getRating());
                RatingBar checkout = findViewById(R.id.ratingBarCheckout);
                currentRating.setCheckoutRating(checkout.getRating());
                final float overAllScore = (liquor.getRating() + produce.getRating()+meat.getRating()+cheese.getRating()+checkout.getRating())/5;

                boolean wasSuccessful = true;
                RatingDataSource ds = new RatingDataSource(RatingsActivity.this);
                try {
                    ds.open();
                    int newID = ds.getMarketNameToID(sentFromMain);
                    currentRating.setSuperMarketID(newID);
                    wasSuccessful = ds.updateContact(currentRating);
                    ds.close();
                } catch (Exception e) {
                    wasSuccessful = false;
                }
                if (wasSuccessful) {
                    Intent intent = new Intent(RatingsActivity.this, SaveConfirmation.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    String getName = sentFromMain;
                    String overAllText = String.valueOf(overAllScore);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("namekey", getName);
                    intent.putExtra("overallkey", overAllText);
                    startActivity(intent);
                }
            }
        });
    }

    private void initListButton() {
        ImageButton listButton = findViewById(R.id.buttonList);
        Intent intent = getIntent();
        String sentFromMain = intent.getStringExtra("namekey");
        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RatingsActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                String returnName = sentFromMain;
                intent.putExtra("namekey", returnName);
                startActivity(intent);
            }
        });
    }

    private void initCatButton() {
        ImageButton catButton = findViewById(R.id.buttonCat);
        Intent intent = getIntent();
        String sentFromMain = intent.getStringExtra("namekey");
        catButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RatingsActivity.this, TheNet.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                String returnName = sentFromMain;
                intent.putExtra("namekey", returnName);
                startActivity(intent);
            }
        });


    }


}











