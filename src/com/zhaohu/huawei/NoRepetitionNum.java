package com.zhaohu.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class NoRepetitionNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();
            getNoRepetitionNum(a);
        }
    }

    public static void getNoRepetitionNum(int num) {
        int[] nums = new int[10];
        Arrays.fill(nums, -1);
        while (num > 0) {
            int current = num % 10;
            if (nums[current] < 0) {
                nums[current] = 0;
                System.out.print(current);
            }
            num = num / 10;
        }

    }
}
