package com.zhaohu.offer.day1;

/**
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 */
public class IntegerDivision {
    public static void main(String[] args) {
//        System.out.println(division(15,2));
//        System.out.println(division(-15,2));
//        System.out.println(division(15,-2));
//        System.out.println(division(-15,-2));
        System.out.println(division(16, 2));
    }

    private static int division(int a, int b) {
        int c = 0;

        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;

        boolean positive = (a ^ b) >= 0;
        a = a < 0 ? a : -a;
        b = b < 0 ? b : -b;
        while (a <= b) {
            a -= b;
            c++;
        }

        return positive ? c : -c;
    }

    //根据倍数进行测试 未完成
//    private static int divisionByMultiple(int a, int b) {
//        int result = 0;
//        boolean positive = (a ^ b) >= 0;
//        if (a == Integer.MIN_VALUE && b == -1) {
//            return Integer.MAX_VALUE;
//        }
//        a = a < 0 ? -a : a;
//        b = b < 0 ? -b : b;
//
//        if (a > b && a > (1 << 30)) {
//            return 0;
//        } else if (a == b) {
//            return positive ? 1 : -1;
//        }
//        int c = b << 0;
//        while (a >= c) {
//            c = b << ++result;
//            if (c > a && a > b) {
//                a = c - a;
//                c = b << 0;
//            }
//        }
//        result = 1 << result;
//        return positive ? result : -result;
//    }
}
