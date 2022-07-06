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
     * @param columnTitle
     * @return
     */
    public int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int num=1;
        int total=0;
        for (int i = 0; i < chars.length ; i++) {
            total+=num*(chars[chars.length-1-i]-'A'+1);
            num*=26;
        }

        return total;
    }


    public int divide(int dividend, int divisor) {
        //被除数最小值
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1)
                return Integer.MIN_VALUE;
            if (divisor == -1)
                return Integer.MAX_VALUE;
        }
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        if (dividend == 0)
            return 0;

        boolean rev = false;
        if (dividend > 0) {
            dividend = -dividend;
            rev = !rev;
        }
        if (divisor > 0) {
            divisor = -divisor;
            rev = !rev;
        }
        int left = 1, right = Integer.MAX_VALUE, ans = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            boolean check = quickAdd(divisor, mid, dividend);
            if (check) {
                ans = mid;
                if (mid == Integer.MAX_VALUE) {
                    break;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return rev ? -ans : ans;
    }

    public boolean quickAdd(int y, int z, int x) {
        int result = 0, add = y;
        while (z != 0) {
            if ((z & 1) != 0) {
                if (result < x - add)
                    return false;
                result += add;
            }
            if (z != 1) {
                if (add < x - add)
                    return false;

                add += add;
            }
            z >>= 1;
        }

        return true;
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
