package com.example.matrank;

class Determinant {

    static int Order = 3;

    private static void getCofactor(int[][] mat, int[][] temp, int p, int q, int n) {
        int i = 0, j = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row != p && col != q) {
                    temp[i][j++] = mat[row][col];

                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    static int getDeterminant(int[][] mat, int n) {
        int D = 0;

        if (n == 1)
            return mat[0][0];

        int[][] temp = new int[Order][Order];

        int sign = 1;

        for (int i = 0; i < n; i++) {
            getCofactor(mat, temp, 0, i, n);
            D += sign * mat[0][i] * getDeterminant(temp, n - 1);

            sign *= -1;
        }

        return D;
    }

}
