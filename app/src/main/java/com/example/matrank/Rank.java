package com.example.matrank;

public class Rank {

    // Some constants
    static int Row = 3;
    static int Col = 3;

    // To swap two rows
    private void swap(int[][] mat, int row1, int row2, int col) {
        for (int i = 0; i < col; i++) {
            int temp = mat[row1][i];
            mat[row1][i] = mat[row2][i];
            mat[row2][i] = temp;
        }
    }

    // Display the matrix in the console
    private void display(int[][] mat) {
        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Col; j++) {
                System.out.print(mat[i][j] + " ");  // Element (i, j) in the matrix
            }
            System.out.println();       // for line break
        }
    }

    private int getRank(int[][] mat) {
        int rank = Math.min(Row, Col);

        for (int row = 0; row < rank; row++) {
            if (mat[row][row] != 0) {
                for (int col = 0; col < Row; col++) {
                    if (col != row) {
                        double multi = (double) mat[col][row] / mat[row][row];
                        for (int i = 0; i < rank; i++) {
                            mat[col][i] -= multi * mat[row][i];
                        }
                    }
                }
            } else {
                boolean reduce = true;

                for (int i = row + 1; i < Row; i++) {
                    if (mat[i][row] != 0) {
                        swap(mat, row, i, rank);
                        reduce = false;
                        break;
                    }
                }

                if (reduce) {
                    rank--;

                    for (int i = 0; i < Row; i++) {
                        mat[i][row] = mat[i][rank];
                    }

                    row--;
                }
            }
        }

        return rank;
    }
}
