package app.improvementapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity {

    TextView dataTextView;
    TextView data1TextView;
    DBHelper dbHelper;
    //private static final String DATE1 = "date";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        dataTextView = findViewById(R.id.textView4);
        data1TextView = findViewById(R.id.textView3);

        dbHelper = new DBHelper(this);

        SQLiteDatabase database = dbHelper.getReadableDatabase();
        String[] projection = {"id", "date", "checked1", "checked2", "checked3", "checked4", "checked5", "checked6", "checked7", "checked8", "checked9", "checked10", "checked11", "checked12", "checked13", "checked14"}; // Replace COLUMN_NAME with the column name from your table

        Cursor cursor = database.query("checkbox_table2", projection, null, null, null, null, null);

        StringBuilder stringBuilder = new StringBuilder();

        int points = 0;
        int pointsSum = 0;

        while (cursor.moveToNext()) {

            String id = String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
            String data = cursor.getString(cursor.getColumnIndexOrThrow("date")); // Replace COLUMN_NAME with the column name from your table
            String checked1 = String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("checked1")));
            String checked2 = String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("checked2")));
            String checked3 = String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("checked3")));
            String checked4 = String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("checked4")));
            String checked5 = String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("checked5")));
            String checked6 = String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("checked6")));
            String checked7 = String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("checked7")));

            String checked8 = String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("checked8"))); //bad
            String checked9 = String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("checked9")));
            String checked10 = String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("checked10")));
            String checked11 = String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("checked11")));
            String checked12 = String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("checked12")));
            String checked13 = String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("checked13")));
            String checked14 = String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("checked14")));

            if(checked1.equals("1")){
                points++;
                pointsSum++;
            }
            if(checked2.equals("1")){
                points++;
                pointsSum++;
            }
            if(checked3.equals("1")){
                points++;
                pointsSum++;
            }
            if(checked4.equals("1")){
                points++;
                pointsSum++;
            }
            if(checked5.equals("1")){
                points++;
                pointsSum++;
            }
            if(checked6.equals("1")){
                points++;
                pointsSum++;
            }
            if(checked7.equals("1")){
                points++;
                pointsSum++;
            }
            if(checked8.equals("1")){ // Šlykštūs puslapiai
                points = points - 7;
                pointsSum = pointsSum - 7;
            }
            if(checked9.equals("1")){ // Nikotinas
                points = points - 700;
                pointsSum = pointsSum - 700;
            }
            if(checked10.equals("1")){ // Etanolis
                points = points - 70;
                pointsSum = pointsSum - 70;
            }
            if(checked11.equals("1")){ // Nesveikas Maistas
                points = points - 7;
                pointsSum = pointsSum - 7;
            }
            if(checked12.equals("1")){ // Vaizdo Žaidimai
                points = points - 7;
                pointsSum = pointsSum - 7;
            }
            if(checked13.equals("1")){ // Keptas Maistas
                points = points - 3;
                pointsSum = pointsSum - 3;
            }
            if(checked14.equals("1")){ // Orgazmas
                points = points - 105;
                pointsSum = pointsSum - 105;
            }

            String pointsString = String.valueOf(points);

            stringBuilder.append(id).append(". ").append(data).append(" ").append(".Taškai: ").append(pointsString).append(" ").append("\n");
            points = 0;
        }

        cursor.close();

        String pointss = "Taškai: " + pointsSum + " !!!!!!!";

        dataTextView.setText(stringBuilder.toString());
        data1TextView.setText(pointss);

        Button btnBack = findViewById(R.id.button6);

        btnBack.setOnClickListener(v -> backToMain());

    }

    public void backToMain() {
        Intent intent = new Intent(ListActivity.this, MainActivity.class);
        startActivity(intent);
    }

}
