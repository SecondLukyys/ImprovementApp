package app.improvementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// Pabandyti susikurti forma
// Pabandyti susikurti sąraša
// Pabandyti susikurti taškų sistemą
// Pabandyti išsaugoti duomenis

public class MainActivity extends AppCompatActivity {

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