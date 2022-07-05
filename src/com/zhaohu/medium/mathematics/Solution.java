package com.zhaohu.medium.mathematics;

import java.util.*;

public class Solution {
    /**
     * 快乐树
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        List<Integer> result = new ArrayList<>();
        while (n != 1) {
            if (result.contains(n))
                return false;
            result.add(n);
            n = changeN(n);
        }
        return true;
    }

    private int changeN(int n) {
        int newN = 0;
        while (n > 0) {
            newN += Math.pow(n % 10, 2);
            n = n / 10;
        }

        return newN;
    }

    /**
     * 阶乘后的0
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int result = 0;
        while (n >= 5) {
            result += n / 5;
            n = n / 5;
        }

        return result;
    }

    /**
     * excel序列号
     *
     * @param columnTitle
     * @return
     */
    public int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int num = 1;
        int total = 0;
        for (int i = 0; i < chars.length; i++) {
            total += num * (chars[chars.length - 1 - i] - 'A' + 1);
            num *= 26;
        }

        return total;
    }


    /**
     * 长除法
     *
     * @param numerator
     * @param denominator
     * @return
     */
    public String fractionToDecimal(int numerator, int denominator) {
        long numeratorL = numerator;
        long denominatorL = denominator;
        boolean positive = false;
        if (numerator > 0) {
            numeratorL = -numerator;
            positive = !positive;
        }
        if (denominator > 0) {
            denominatorL = -denominator;
            positive = !positive;
        }


        Map<Long, Integer> keys = new HashMap<>();
        long integer = numeratorL / denominatorL;
        StringBuilder stringBuilder = new StringBuilder();
        long remainder = 0;
        int index = 0;
        while ((remainder = numeratorL % denominatorL) != 0) {
            if (keys.containsKey(remainder)) {
                int start = keys.get(remainder);
                stringBuilder.insert(start, "(");
                stringBuilder.append(")");
                break;
            }
            keys.put(remainder, index++);
            numeratorL = remainder * 10;
            stringBuilder.append(numeratorL / denominatorL);
        }

        if(keys.size()>0)
            stringBuilder.insert(0,".");
        stringBuilder.insert(0, integer);


        if (positive && numerator!=0)
            stringBuilder.insert(0, "-");

        return stringBuilder.toString();
    }
}
