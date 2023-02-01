package com.example.supermarket;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

    /*
The Data Access class it the class that opens and closes the database and
contains the queries used to store and retrieve data from the database.
 */
    public class RatingDataSource {
        private SQLiteDatabase database;
        private RatingDBHelper dbHelper;

        //the helper and data source classes are instantiated
        public RatingDataSource(Context context) {
            dbHelper = new RatingDBHelper(context);
        }

        public void open() throws SQLException {
            database = dbHelper.getWritableDatabase();
        }

        public void close() {
            dbHelper.close();
        }


        //Insert and Update Contact Methods
        public boolean insertRating(Rating r) {

            boolean didSucceed = false;
            try {
                database = dbHelper.getWritableDatabase();
                ContentValues initialValues = new ContentValues();  //obj used to store key/value pairs

                //Values are retrieved from the Rating object and inserted into the ContentValues obj
                initialValues.put("supermarketname", r.getSuperMarketName());
                initialValues.put("streetaddress", r.getStreetAddress());
                initialValues.put("city", r.getCity());
                initialValues.put("state", r.getState());
                initialValues.put("zipcode", r.getZipCode());
                initialValues.put("liquorrating", String.valueOf(r.getLiquorRating()));
                initialValues.put("producerating", r.getProduceRating());
                initialValues.put("meatrating", r.getMeatRating());
                initialValues.put("cheeserating", r.getCheeseRating());
                initialValues.put("checkoutrating", r.getCheckoutRating());

            /*
          The didSucceed.insert called and passed to the name of the table and values to insert
          returning the number of rows updated. If it's greater than 0 the operation succeeded and the
          return value is set to true.
            */
                // didSucceed = database.insert("contact", null, initialValues) > 0;


                didSucceed = database.insert("rating", null, initialValues) > 0;

            } catch (Exception e) {
                //if an exception is thrown the value remains false because the 0 is not greater than 0
            }
            return didSucceed;

        }

        public boolean updateContact(Rating r) {
            boolean didSucceed = false;
            try {
                Long rowID = (long) r.getSuperMarketID();
            /*
            Update Procedure need the contactID to correctly update the table. Value retreived
            from contact object and assigned to the var
            */
                ContentValues updateValues = new ContentValues();

                updateValues.put("liquorrating", r.getLiquorRating());
                updateValues.put("producerating", r.getProduceRating());
                updateValues.put("meatrating", r.getMeatRating());
                updateValues.put("cheeserating", r.getCheeseRating());
                updateValues.put("checkoutrating", r.getCheckoutRating());

                didSucceed = database.update("rating", updateValues, "_id=" + rowID, null) > 0;
            } catch (Exception e) {

            }
            return didSucceed;
        }

        /*
If the user adds a new contact, presses the Save button, and then edits the data and presses Save again,
another contact will be added, rather than updating the contact just entered.
This is because the currentContact object still has an ID of –1
This gets the new ID and set the currentContact contactID attribute to that value.
 */
        public int getLastMarketID() {
            int lastID;
            try {
                String query = "Select MAX(_id) from rating";
                Cursor cursor = database.rawQuery(query, null); //query that returns the last (max) _id
//A cursor is declared and assigned to hold the results of the execution of the query. A cursor is an object that is used to hold and move through the results of a query.
                cursor.moveToFirst(); //Cursor is told to move to the first record in the returned data.
                lastID = cursor.getInt(0);  //The maximum ID is retrieved from the record set. Fields in the record set are indexed starting at 0.
                cursor.close();  // Dont forget to close dp's and cursors!!!
            } catch (Exception e) {
                lastID = -1;
            }
            return lastID;
        }

        public int getMarketNameToID(String name) throws Exception{
            String marketIdFromName = name;
            int nameToMarketID;
                String query = "Select _id from rating where supermarketname = '" + marketIdFromName + "'" ;
                Cursor cursor = database.rawQuery(query, null); //query that returns the last (max) _id
//A cursor is declared and assigned to hold the results of the execution of the query. A cursor is an object that is used to hold and move through the results of a query.
                cursor.moveToFirst(); //Cursor is told to move to the first record in the returned data.
                nameToMarketID = cursor.getInt(0);  //The maximum ID is retrieved from the record set. Fields in the record set are indexed starting at 0.
                cursor.close();
                return nameToMarketID;

        }

    }
