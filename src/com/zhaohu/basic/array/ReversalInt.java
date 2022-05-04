package com.zhaohu.basic.array;

public class ReversalInt {
    public static void main(String[] args) {
        reverse(1534236469);
    }

    public static int reverse(int x) {
        if (x < 10 && x > -10)
            return x;
        boolean negative = x > 0 ? false : true;
        if (negative) x = 0 - x;
        int result = 0;
        while (x > 0) {
            int remainder = x % 10;
            x = x / 10;
            int res = result * 10 + remainder;
            if ((res - remainder) / 10 != result)
                return 0;
            result = res;
        }

        return negative ? -result : result;
    }
}
