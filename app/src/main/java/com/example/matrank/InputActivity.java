package com.example.matrank;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class InputActivity extends AppCompatActivity {

    EditText mat_text;
    TextView mat_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        mat_text = findViewById(R.id.matrix_input_text);
        mat_container = findViewById(R.id.matrix_container);
        mat_container.setText("");
    }

    public void BackButtonClicked(View view) {
        // Perform pre-processing before finishing the activity.

        finish();
    }

    public void SubmitClicked(View view) {
        // Submit the result back to the intent that called this.

        int[][] mat;

        if (String.valueOf(mat_container.getText()).split(" ").length > 0) {

            boolean broken = false;
            int Row = 0;
            int Col = 0;

            for (String line : String.valueOf(mat_container.getText()).split("\n")) {
                line = line.trim();

                if (Col == 0) {
                    Col = line.split(" ").length;
                    Log.d("SubmitClicked", "Col = -1 : " + Col);
                    Log.d("SubmitClicked", String.format("Line : %s", Arrays.toString(line.split(" "))));
                } else if (Col != line.split(" ").length) {
                    Log.d("SubmitClicked", "Col : " + Col);
                    Log.d("SubmitClicked", "Line : " + line.split(" ").length);

                    Toast.makeText(this, "Matrix Invalid. Please Enter the Matrix Again.", Toast.LENGTH_SHORT).show();
                    broken = true;
                    break;
                }

                Row++;
            }

            // Break out if the last loop was broken.
            if (broken) {
                return;
            }

            // initialize the Matrix of Required Size
            mat = new int[Row][Col];

            // Iterate over each line and split it into its respective elements
            // Get some variables ready for temporary storage
            int t_row = 0;
            int t_col = 0;

            for (String line : String.valueOf(mat_container.getText()).split("\n")) {
                for (String elem : line.split(" ")) {
                    mat[t_row][t_col] = Integer.parseInt(elem);
                    t_col++;
                }
                t_row++;
                t_col = 0;
            }

            // Now we have the Matrix done and we can pass this back to the Caller.
            // We also calculate the rank here, so we already have the rank when required.

            Rank.Row = mat.length;
            Rank.Col = mat[0].length;
            int rank = Rank.getRank(mat);
            String matrix = Rank.getStringMatrix(mat, Rank.Row, Rank.Col);

            // Return the activity results and close this activity
            Intent intent = new Intent(InputActivity.this, MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("matrix", matrix);
            bundle.putInt("rank", rank);
            intent.putExtras(bundle);

            setResult(RESULT_OK, intent);
            finish();

        } else {
            Toast.makeText(this, "Enter a Valid Matrix", Toast.LENGTH_SHORT).show();
        }
    }

    public void AddRow(View view) {
        if (String.valueOf(mat_text.getText()).trim().length() != 0) {

            String old = String.valueOf(mat_container.getText());
            String now = String.valueOf(mat_text.getText());

            if (old.trim().equals("")) {
                old += now;
            } else {
                old += "\n" + now;
            }

            mat_container.setText(old);
            mat_text.setText("");
        } else {
            Toast.makeText(this, "Enter Elements of the Row", Toast.LENGTH_SHORT).show();
        }
    }
}
