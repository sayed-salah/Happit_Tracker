package com.example.sayedsalah.happit_tracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "contactsDB";
    private static final String TABLE_CONTACTS = "contacts";
    private static final String CONTACT_NAME = "contact_name";
    private static final String PHONE_NUMBER = "phone_number";

    public DatabaseHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String quiry = "CREATE TABLE "+TABLE_CONTACTS +"("+CONTACT_NAME+" TEXT NOT NULL, "+PHONE_NUMBER+" INTEGER NOT NULL)";
        sqLiteDatabase.execSQL(quiry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        onCreate(sqLiteDatabase);
    }

    public void insert(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CONTACT_NAME, contact.getContactName());
        values.put(PHONE_NUMBER, contact.getPhoneNumber());

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);

        // Closing database connection
        db.close();
    }

    public ArrayList<Contact> getAllContacts() {
        ArrayList<Contact> contactsList = new ArrayList<Contact>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setContactName(cursor.getString(0));
                contact.setPhoneNumber(Integer.parseInt(cursor.getString(1)));
                // Adding contact to list
                contactsList.add(contact);
            } while (cursor.moveToNext());
        }

        // Closing database connection
        db.close();

        // return contacts list
        return contactsList;
    }
}
