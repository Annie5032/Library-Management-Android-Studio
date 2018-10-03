package library.management;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "libraryDatabase";

    // Table Names
    private static final String TABLE_PUBLISHER = "publisher";
    private static final String TABLE_BOOK = "book";
    private static final String TABLE_LOCATION = "location";
    private static final String TABLE_PUBLISHER_BOOK_LOCATION = "publisher_book_location";

    // Common column names
    private static final String KEY_ID = "id";

    // PUBLISHER Table - column names
    private static final String KEY_NAME = "publisherName";
    private static final String KEY_BOOK_WIDTH = "bookWidth";

    // BOOK Table - column names
    private static final String KEY_BOOK_NAME = "bookName";
    private static final String KEY_BOOK_CASE = "bookCase";
    private static final String KEY_BOOK_SHELF = "bookShelf";
    private static final String KEY_BOOK_POSITION = "bookPosition";

    //LOCATION Table - column names
    private static final String KEY_LOCATION_IMAGE = "locationImage";

    // PUBLISHER_BOOK_LOCATION Table - column names
    private static final String KEY_PUBLISHER_ID = "publisher_id";
    private static final String KEY_BOOK_ID = "book_id";
    private static final String KEY_LOCATION_ID = "location_id";

    // Table Create Statements
    // Publisher table create statement
    private static final String CREATE_TABLE_PUBLISHER = "CREATE TABLE "
            + TABLE_PUBLISHER + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_BOOK_WIDTH + " DOUBLE" + ")";

    // Book table create statement
    private static final String CREATE_TABLE_BOOK = "CREATE TABLE " + TABLE_BOOK
            + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_BOOK_NAME + " TEXT,"
            + KEY_BOOK_CASE + " TEXT," + KEY_BOOK_SHELF + " TEXT," + KEY_BOOK_POSITION
            + " INTEGER" + ")";

    //Location table create statement
    private static final String CREATE_TABLE_LOCATION = "CREATE TABLE " + TABLE_LOCATION
            + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_LOCATION_IMAGE + " BLOB" + ")";

    // Publisher_Book_Location table create statement
    private static final String CREATE_TABLE_PUBLISHER_BOOK_LOCATION = "CREATE TABLE "
            + TABLE_PUBLISHER_BOOK_LOCATION + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_PUBLISHER_ID + " INTEGER," + KEY_BOOK_ID + " INTEGER,"
            + KEY_LOCATION_ID + " INTEGER" + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_PUBLISHER);
        db.execSQL(CREATE_TABLE_BOOK);
        db.execSQL(CREATE_TABLE_LOCATION);
        db.execSQL(CREATE_TABLE_PUBLISHER_BOOK_LOCATION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PUBLISHER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOK);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCATION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PUBLISHER_BOOK_LOCATION);

        ContentValues values = new ContentValues();

        values.put(KEY_NAME, "Hynes Combine");
        values.put(KEY_BOOK_WIDTH, "3.2");
        db.insert(TABLE_PUBLISHER, KEY_NAME, values);

        values.put(KEY_NAME, "House Brooker");
        values.put(KEY_BOOK_WIDTH, "3.2");
        db.insert(TABLE_PUBLISHER, KEY_NAME, values);

        // create new tables
        onCreate(db);
    }

    public ArrayList<publisherTable> getAllPublishers() {
        ArrayList<publisherTable> publishers = new ArrayList<publisherTable>();
        String selectQuery = "SELECT  publisherName FROM " + TABLE_PUBLISHER +
                " WHERE " + KEY_NAME + " = 'bob'";

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                publisherTable td = new publisherTable();
                td.setId(c.getInt((c.getColumnIndex(KEY_ID))));
                td.setName((c.getString(c.getColumnIndex(KEY_NAME))));
                td.setBookWidth(c.getDouble(c.getColumnIndex(KEY_BOOK_WIDTH)));

                // adding to todo list
                publishers.add(td);
            } while (c.moveToNext());
        }

        return publishers;
    }
}

