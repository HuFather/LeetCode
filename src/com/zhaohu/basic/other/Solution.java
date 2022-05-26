package com.zhaohu.basic.other;

import java.util.*;

/**
 * @creator : zhaohu
 * @date : 5/23/2022
 * @description :
 */
public class Solution {
    public static void main(String[] args) {
        //int result = hammingWeight(0b11111111111111111111111111111101);

        int result = reverseBits(0b00000010100101000001111010011100);
    }

    public static int hammingWeight(int n) {

        int oneNum = 0;
        while (n != 0) {
            if ((n & 1) == 1)
                oneNum++;
            n >>>= 1;

        }

        return oneNum;
    }


    public static int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result = result | (n & 1);
            n >>= 1;
        }

        return result;

    }

    /**
     * 杨辉三角
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        pre.add(1);

        result.add(pre);
        for (int i = 1; i < numRows; i++) {
            List<Integer> current = new ArrayList<>();
            current.add(1);
            for (int j = 0; j < pre.size() - 1; j++) {
                current.add(pre.get(j) + pre.get(j + 1));
            }
            current.add(1);
            result.add(current);
            pre = current;
        }
        return result;
    }

    /**
     * 括号校验
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || !stack.pop().equals(c))
                return false;

        }
        return stack.isEmpty() ? true : false;
    }

    public int missingNumber(int[] nums) {
        double expectTotal = (0 + nums.length) * (nums.length / 2.0+0.5);
        int total=0;
        for (int i = 0; i < nums.length; i++) {
            total+=nums[i];
        }

        return (int) (expectTotal-total);
    }


}
