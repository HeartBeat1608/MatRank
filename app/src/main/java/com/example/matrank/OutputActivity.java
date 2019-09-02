package com.example.matrank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OutputActivity extends AppCompatActivity {

    TextView text_rank, matrix_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        matrix_container = findViewById(R.id.matrix_container);
        text_rank = findViewById(R.id.text_rank);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        assert bundle != null;

        String mat = bundle.getString("matrix");
        int rank = bundle.getInt("rank");
        String rank_out = "RANK : " + rank;

        matrix_container.setText(mat);
        text_rank.setText(rank_out);
    }

    public void BackButtonClicked(View view) {
        finish();
    }


}
