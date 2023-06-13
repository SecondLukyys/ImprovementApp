package app.improvementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

/**
 * MainActivity class that lets user navigate main maniu from which he is able to access all fuctions
 */
public class MainActivity extends AppCompatActivity {

    //TODO Update some stuff, disign and buttons
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnExit = findViewById(R.id.button);
        Button btnForm = findViewById(R.id.button2);
        Button btnList = findViewById(R.id.button4);
        Button btnRemove = findViewById(R.id.button5);

        btnExit.setOnClickListener(v -> exitApp());

        btnForm.setOnClickListener(v -> openFormActivity());

        btnList.setOnClickListener(v -> openListActivity());

        btnRemove.setOnClickListener(v -> openRemoveActivity());
    }

    public void openFormActivity() {
        Intent intent = new Intent(MainActivity.this, FormActivity.class);
        startActivity(intent);
    }

    private void openListActivity() {
        Intent intent = new Intent(MainActivity.this, ListActivity.class);
        startActivity(intent);
    }

    private void openRemoveActivity() {
        Intent intent = new Intent(MainActivity.this, RemoveActivity.class);
        startActivity(intent);
    }

    public void exitApp() {
        finishAffinity();
    }

}