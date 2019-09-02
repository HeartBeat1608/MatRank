package com.example.matrank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    final int INPUT_REQUEST_CODE = 0x08;
    final int OUTPUT_REQUEST_CODE = 0x16;

    Button btn_input, btn_output;
    ImageButton btn_about;

    int rank = -1;
    String matrix = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_about = findViewById(R.id.button_about);
        btn_input = findViewById(R.id.button_mat_input);
        btn_output = findViewById(R.id.button_mat_output);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == INPUT_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // Assert for any null data or sequence
                assert data != null;
                rank = data.getIntExtra("rank", -1);
                matrix = data.getStringExtra("matrix");
            }
        }
    }

    public void InputClicked(View view) {
        Intent intent = new Intent(MainActivity.this, InputActivity.class);
        startActivityForResult(intent, INPUT_REQUEST_CODE);
    }

    public void OutputClicked(View view) {
        if (rank == -1) {
            Toast.makeText(this, "Unable to Calculate. Please Retry.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(MainActivity.this, OutputActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("rank", rank);
            bundle.putString("matrix", matrix);
            intent.putExtras(bundle);

            startActivity(intent);
        }
    }

    public void AboutClicked(View view) {
        String about = getString(R.string.app_disc);
        Toast.makeText(this, about, Toast.LENGTH_LONG).show();
    }
}
