package app.improvementapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Database helper class that enables database integration
 */
public class DBHelper extends SQLiteOpenHelper {

    //TODO Improve and extend database tables

    private static final String DATABASE_NAME = "checkbox_db.db";
    private static final int DATABASE_VERSION = 2;

    private static final String TABLE_NAME = "checkbox_table2";
    private static final String COLUMN_ID = "id";

    private static final String DATE = "date";
    private static final String COLUMN_CHECKED1 = "checked1";
    private static final String COLUMN_CHECKED2 = "checked2";
    private static final String COLUMN_CHECKED3 = "checked3";
    private static final String COLUMN_CHECKED4 = "checked4";
    private static final String COLUMN_CHECKED5 = "checked5";
    private static final String COLUMN_CHECKED6 = "checked6";
    private static final String COLUMN_CHECKED7 = "checked7";
    private static final String COLUMN_CHECKED8 = "checked8";
    private static final String COLUMN_CHECKED9 = "checked9";
    private static final String COLUMN_CHECKED10 = "checked10";
    private static final String COLUMN_CHECKED11 = "checked11";
    private static final String COLUMN_CHECKED12 = "checked12";
    private static final String COLUMN_CHECKED13 = "checked13";
    private static final String COLUMN_CHECKED14 = "checked14";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DATE + " TEXT,"
                + COLUMN_CHECKED1 + " INTEGER,"
                + COLUMN_CHECKED2 + " INTEGER,"
                + COLUMN_CHECKED3 + " INTEGER,"
                + COLUMN_CHECKED4 + " INTEGER,"
                + COLUMN_CHECKED5 + " INTEGER,"
                + COLUMN_CHECKED6 + " INTEGER,"
                + COLUMN_CHECKED7 + " INTEGER,"
                + COLUMN_CHECKED8 + " INTEGER,"
                + COLUMN_CHECKED9 + " INTEGER,"
                + COLUMN_CHECKED10 + " INTEGER,"
                + COLUMN_CHECKED11 + " INTEGER,"
                + COLUMN_CHECKED12 + " INTEGER,"
                + COLUMN_CHECKED13 + " INTEGER,"
                + COLUMN_CHECKED14 + " INTEGER)";

        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Perform upgrade operations if needed
        // This method is called when the database version is increased
    }
}
