package com.zhaohu.medium.ohters;

public class Solution {


    /**
     * 两整数之和
     *
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }

        return a;
    }
}
