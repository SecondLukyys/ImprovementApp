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
    DBHelper dbHelper;
    private static final String DATE1 = "date";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        dataTextView = findViewById(R.id.textView3);
        dbHelper = new DBHelper(this);

        SQLiteDatabase database = dbHelper.getReadableDatabase();
        String[] projection = {DATE1}; // Replace COLUMN_NAME with the column name from your table
        Cursor cursor = database.query("checkbox_table2", projection, null, null, null, null, null);

        StringBuilder stringBuilder = new StringBuilder();

        while (cursor.moveToNext()) {
            String data = cursor.getString(cursor.getColumnIndexOrThrow(DATE1)); // Replace COLUMN_NAME with the column name from your table
            stringBuilder.append(data).append("\n");
        }

        cursor.close();

        dataTextView.setText(stringBuilder.toString());

        Button btnBack = findViewById(R.id.button6);

        btnBack.setOnClickListener(v -> backToMain());

    }

    public void backToMain() {
        Intent intent = new Intent(ListActivity.this, MainActivity.class);
        startActivity(intent);
    }

}
