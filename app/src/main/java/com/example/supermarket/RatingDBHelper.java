package com.example.supermarket;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class RatingDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ratings.dp";
    private static final int DATABASE_VERSION = 2;
    /*Everytime the database is accessed it looks at this version if it is
    if the number is higher the onUpgrade method is called. The developer
    only needs to update this version number
    * */

    private static final String CREATE_TABLE_CONTACT =  /*
    Creates the table. BBP define the table definitions like above so when
    changes to the table are needed all you do is change the definition in one
    place and increment the version number
    */
            "create table rating (_id integer primary key AUTOINCREMENT,"
                    + "supermarketname text not null, streetaddress text,"
                    + "city text, state text, zipcode text,"
                    + "liquorrating text, producerating text, meatrating text,"
                    + "cheeserating text, checkoutrating text);";

    public RatingDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    /*
    Oncreate is called the first time the db is opened. If the db named
    in the DATABASE_Name var does not exist this method is executed which
    executes the SQL assigned to the CREATE_TABLE_CONTACT variable.
     */
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CONTACT);
    }

    @Override
    /* CAREFUL
    if a table is dropped, all the user data currently in the table
    is lost. If you need to add columns to the table, consider executing
    an ALTER TABLE SQL command rather than a drop, and re-create the table.
    The Log command writes a message to LogCat
     */
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(RatingDBHelper.class.getName(),
                "Upgrading database from version" + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        onCreate(db);
    }



}
