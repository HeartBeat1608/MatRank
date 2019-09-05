package com.example.matrank;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class DeterminantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_determinant);


    }

    private void findRank(int[][] mat, int n) {
        int N = n;

        Determinant.Order = N;

        for (int i = 0; i < mat[0].length; i++) {
            Determinant.getDeterminant(mat, N);
        }
    }
}
