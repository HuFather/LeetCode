package com.zhaohu.basic.array;

/**
 * 旋转二维数组
 */
public class RotateMatrix {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                int row = n - i - 1;
                int clown = n - j - 1;
                matrix[i][j] = matrix[clown][i];
                matrix[clown][i] = matrix[row][clown];
                matrix[row][clown] = matrix[clown][j];
                matrix[clown][j] = temp;
            }
        }
    }
}
