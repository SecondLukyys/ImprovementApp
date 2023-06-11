package app.improvementapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RemoveActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        editText = findViewById(R.id.editTextNumber);
        Button btnBack = findViewById(R.id.button7);
        Button btnRemove = findViewById(R.id.button8);

        btnBack.setOnClickListener(v -> backToMain());
        btnRemove.setOnClickListener(v -> removeData());
    }

    public void backToMain() {
        Intent intent = new Intent(RemoveActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void removeData() {
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        String number = String.valueOf(editText.getText());

        // Define the table name and the column name for the ID
        String tableName = "checkbox_table2";
        String idColumn = "id";

        // Construct the selection criteria with the ID value
        String selection = idColumn + " = ?";
        String[] selectionArgs = {number};

        // Perform the delete operation
        int rowsDeleted = database.delete(tableName, selection, selectionArgs);

        if (rowsDeleted > 0) {
            Toast.makeText(this, "Data removed successfully", Toast.LENGTH_SHORT).show();
            refresh();
        } else {
            Toast.makeText(this, "Failed to remove data", Toast.LENGTH_SHORT).show();
            refresh();
        }
    }

    public void refresh() {

        Intent intent = new Intent(RemoveActivity.this, RemoveActivity.class);
        startActivity(intent);

    }

}
