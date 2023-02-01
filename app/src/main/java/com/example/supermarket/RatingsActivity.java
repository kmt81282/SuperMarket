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
                    Intent intent = new Intent(RatingsActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            }
        });
    }

    private void initListButton(){
        ImageButton listButton = findViewById(R.id.buttonList);
        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RatingsActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                String returnName = currentRating.getSuperMarketName();
                intent.putExtra("returnname", returnName);
                startActivity(intent);
            }
        });
    }

    public void calcRatingButton() {
        AlertDialog.Builder builder = new AlertDialog.Builder(RatingsActivity.this);

    }








/*
    public int initCalculation() {
        ImageButton calculate = findViewById(R.id.buttonCalculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Intent intent = new Intent(RatingsActivity.this, ViewStarCalculationDialog.class);
              //  intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                RatingBar liquor = findViewById(R.id.ratingBarLiquor);
                RatingBar produce = findViewById(R.id.ratingBarProduce);
                RatingBar meat = findViewById(R.id.ratingBarMeat);
                RatingBar cheese = findViewById(R.id.ratingBarCheese);
                RatingBar checkout = findViewById(R.id.ratingBarCheckout);
                float overAllScore = (liquor.getRating() + produce.getRating() + meat.getRating() + cheese.getRating() + checkout.getRating()) / 5;
                FragmentManager fm = getSupportFragmentManager();
                ViewStarCalculationDialog viewStarCalculationDialog = new ViewStarCalculationDialog();
                viewStarCalculationDialog.show(fm,"ratings");

            }
        });

    }


 */



}





