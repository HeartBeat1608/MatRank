package com.example.matrank;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn_input, btn_output;
    ImageButton btn_about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_about = findViewById(R.id.button_about);
        btn_input = findViewById(R.id.button_mat_input);
        btn_output = findViewById(R.id.button_mat_output);
    }

    public void InputClicked(View view) {
        Toast.makeText(this, "Matrix Input Activity Clicked", Toast.LENGTH_SHORT).show();
    }

    public void OutputClicked(View view) {
        Toast.makeText(this, "Matrix Output Activity Clicked", Toast.LENGTH_SHORT).show();
    }

    public void AboutClicked(View view) {
        String about = getString(R.string.app_disc);
        Toast.makeText(this, about, Toast.LENGTH_SHORT).show();
    }
}
