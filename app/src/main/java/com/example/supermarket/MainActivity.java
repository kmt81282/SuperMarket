package com.example.supermarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Rating currentRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSaveButton();
        initTextChangeEvents();

        currentRating = new Rating();
        Intent intent = getIntent();
        String returnedName = intent.getStringExtra("namekey");
        String returnedRating = intent.getStringExtra("overallkey");
        TextView messageDisplay = findViewById(R.id.textMessageSave);
        Resources res = getResources();
        if (returnedName != null) {
            messageDisplay.setText(res.getString(R.string.welcome_back, returnedName, returnedRating));
        } else {
            messageDisplay.setText(res.getString(R.string.welcome_message));
        }

    }
/*
    private void initSaveButton() {
        ImageButton ibList = findViewById(R.id.buttonSave);
        ibList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RatingsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }


        });
    }
*/
    private void initTextChangeEvents() {
        final EditText etMarketName = findViewById(R.id.editName);
        etMarketName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentRating.setSuperMarketName(etMarketName.getText().toString());

            }
        });
        final EditText etAddress = findViewById(R.id.editAddress);
        etAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentRating.setStreetAddress(etAddress.getText().toString());

            }
        });
        final EditText etCity = findViewById(R.id.editCity);
        etCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentRating.setCity(etCity.getText().toString());

            }
        });
        final EditText etState =findViewById(R.id.editState);
        etState.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentRating.setCity(etState.getText().toString());
            }
        });
        final EditText etZip = findViewById(R.id.editZipcode);
        etZip.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentRating.setZipCode(etZip.getText().toString());

            }
        });
    }
    private void initSaveButton() {
        ImageButton saveButton = findViewById(R.id.buttonSave);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean wasSuccessful = true;
                RatingDataSource ds = new RatingDataSource(MainActivity.this);
                try {
                    ds.open();

                    String marketName = currentRating.getSuperMarketName();

                    if(currentRating.getSuperMarketID() == -1) {
                        wasSuccessful = ds.insertRating(currentRating);

                        if (wasSuccessful) {
                            int newID = ds.getMarketNameToID(marketName);
                            currentRating.setSuperMarketID(newID);
                        }
                    }
                    ds.close();

                }
                catch (Exception e) {
                    wasSuccessful = false;
                }
                if (wasSuccessful) {
                            Intent intent = new Intent(MainActivity.this, RatingsActivity.class);
                            String getName = currentRating.getSuperMarketName();
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            intent.putExtra("namekey", getName);
                            startActivity(intent);
                }
            }
        });
    }

}




