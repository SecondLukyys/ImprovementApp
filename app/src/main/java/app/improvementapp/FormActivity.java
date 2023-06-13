package app.improvementapp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

/**
 * FormActivity class that lets user to create a new record to a database that tracks good and bad activities, also counts points
 */
public class FormActivity extends AppCompatActivity {

    //TODO Upgrade points, choices and logic
    private CheckBox checkbox1, checkbox2, checkbox3, checkbox4, checkbox5, checkbox6, checkbox7, checkbox8, checkbox9, checkbox10, checkbox11, checkbox12, checkbox13, checkbox14;
    private SQLiteDatabase database;
    private DBHelper dbHelper;


    Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH) + 1; // Month starts from 0, so add 1
    int day = calendar.get(Calendar.DAY_OF_MONTH);

    String newMonth = fixMonth(month);

    String date = year + "-" + newMonth + "-" + day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        checkbox1 = findViewById(R.id.checkBox4);
        checkbox2 = findViewById(R.id.checkBox5);
        checkbox3 = findViewById(R.id.checkBox6);
        checkbox4 = findViewById(R.id.checkBox7);
        checkbox5 = findViewById(R.id.checkBox14);
        checkbox6 = findViewById(R.id.checkBox8);
        checkbox7 = findViewById(R.id.checkBox);

        checkbox8 = findViewById(R.id.checkBox15);
        checkbox9 = findViewById(R.id.checkBox9);
        checkbox10 = findViewById(R.id.checkBox10);
        checkbox11 = findViewById(R.id.checkBox11);
        checkbox12 = findViewById(R.id.checkBox12);
        checkbox13 = findViewById(R.id.checkBox13);
        checkbox14 = findViewById(R.id.checkBox3);

        dbHelper = new DBHelper(this);

        database = dbHelper.getWritableDatabase();

        Button btnBack = findViewById(R.id.button3);
        Button btnClear = findViewById(R.id.button9);
        Button btnEnter = findViewById(R.id.button10);

        btnBack.setOnClickListener(v -> backToMain());

        btnClear.setOnClickListener(v -> clearBoxes());

        btnEnter.setOnClickListener(v -> enterData());
    }

    public void backToMain() {
        Intent intent = new Intent(FormActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void clearBoxes() {

        Intent intent = new Intent(FormActivity.this, FormActivity.class);
        startActivity(intent);

    }

    public void enterData() {
        ContentValues values = new ContentValues();

        values.put("date", date);
        values.put("checked1", checkbox1.isChecked() ? 1 : 0);
        values.put("checked2", checkbox2.isChecked() ? 1 : 0);
        values.put("checked3", checkbox3.isChecked() ? 1 : 0);
        values.put("checked4", checkbox4.isChecked() ? 1 : 0);
        values.put("checked5", checkbox5.isChecked() ? 1 : 0);
        values.put("checked6", checkbox6.isChecked() ? 1 : 0);
        values.put("checked7", checkbox7.isChecked() ? 1 : 0);

        values.put("checked8", checkbox8.isChecked() ? 1 : 0);
        values.put("checked9", checkbox9.isChecked() ? 1 : 0);
        values.put("checked10", checkbox10.isChecked() ? 1 : 0);
        values.put("checked11", checkbox11.isChecked() ? 1 : 0);
        values.put("checked12", checkbox12.isChecked() ? 1 : 0);
        values.put("checked13", checkbox13.isChecked() ? 1 : 0);
        values.put("checked14", checkbox14.isChecked() ? 1 : 0);

        long rowId = database.insert("checkbox_table2", null, values);

        if (rowId != -1) {
            Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to save data", Toast.LENGTH_SHORT).show();
        }

        printData();
        backToMain();
    }

    private void printData() {
        Cursor cursor = database.rawQuery("SELECT * FROM checkbox_table2", null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("id"));
                @SuppressLint("Range") String date = cursor.getString(cursor.getColumnIndex("date"));
                @SuppressLint("Range") int checked1 = cursor.getInt(cursor.getColumnIndex("checked1"));
                @SuppressLint("Range") int checked2 = cursor.getInt(cursor.getColumnIndex("checked2"));
                @SuppressLint("Range") int checked3 = cursor.getInt(cursor.getColumnIndex("checked3"));
                @SuppressLint("Range") int checked4 = cursor.getInt(cursor.getColumnIndex("checked4"));
                @SuppressLint("Range") int checked5 = cursor.getInt(cursor.getColumnIndex("checked5"));
                @SuppressLint("Range") int checked6 = cursor.getInt(cursor.getColumnIndex("checked6"));
                @SuppressLint("Range") int checked7 = cursor.getInt(cursor.getColumnIndex("checked7"));
                @SuppressLint("Range") int checked8 = cursor.getInt(cursor.getColumnIndex("checked8"));
                @SuppressLint("Range") int checked9 = cursor.getInt(cursor.getColumnIndex("checked9"));
                @SuppressLint("Range") int checked10 = cursor.getInt(cursor.getColumnIndex("checked10"));
                @SuppressLint("Range") int checked11 = cursor.getInt(cursor.getColumnIndex("checked11"));
                @SuppressLint("Range") int checked12 = cursor.getInt(cursor.getColumnIndex("checked12"));
                @SuppressLint("Range") int checked13 = cursor.getInt(cursor.getColumnIndex("checked13"));
                @SuppressLint("Range") int checked14 = cursor.getInt(cursor.getColumnIndex("checked14"));

                String data = "ID: " + id + ", Date: " + date + ", Checked1: " + checked1 + ", Checked2: " + checked2 + ", Checked3: " + checked3 + ", Checked4: " + checked4 + ", Checked5: " + checked5 + ", Checked6: " + checked6 + ", Checked7: " + checked7 + ", Checked8: " + checked8 + ", Checked9: " + checked9 + ", Checked10: " + checked10 + ", Checked11: " + checked11 + ", Checked12: " + checked12 + ", Checked13: " + checked13 + ", Checked14: " + checked14;
                Log.d("Database", data);
            } while (cursor.moveToNext());
        }

        cursor.close();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHelper.close();
    }

    public String fixMonth(int month){

        String newMonth = String.valueOf(month);

        if(month < 10)
            newMonth = "0" + newMonth;

        return newMonth;
    }

}