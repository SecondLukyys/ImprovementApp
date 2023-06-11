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

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitApp();
            }
        });

        Button btnform = findViewById(R.id.button2);

        btnform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFormActivity();
            }
        });

    }

    public void exitApp() {
        finishAffinity();
    }

    public void openFormActivity() {
        Intent intent = new Intent(MainActivity.this, FormActivity.class);
        startActivity(intent);
    }

}