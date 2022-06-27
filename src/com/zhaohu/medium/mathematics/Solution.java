package com.zhaohu.medium.mathematics;

import java.util.ArrayList;
import java.util.List;

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
}
