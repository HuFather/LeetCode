package com.zhaohu.hard.string;

import javafx.scene.Group;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @creator : zhaohu
 * @date : 7/9/2022
 * @description :
 */
public class Solution {
    /**
     * 除自身为数组的乘积
     * @param nums
     * @return
     * @throws IOException
     */
    public int[] productExceptSelf(int[] nums) {
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];

        L[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }

        R[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = L[i] * R[i];
        }

        return result;
    }


    /**
     * 顺时针螺旋顺序
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int time = 0;
        List<Integer> result = new ArrayList<>();

        while (n >= time && m >= time) {
            for (int i = time; i <= n - time; i++) {
                result.add(matrix[time][i]);
            }
            for (int i = time + 1; i <= m - time; i++) {
                result.add(matrix[i][n - time]);
            }
            for (int i = n - time - 1; i > time; i--) {
                result.add(matrix[m - time][i]);
            }
            for (int i = m - time; i >= time + 1; i--)

            time++;
        }

        return result;
    }
}
