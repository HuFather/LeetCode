package com.zhaohu.basic.array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PlusOne {
    public int[] plustOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] == 9) {
                digits[i]=0;
            }else {
                digits[i]++;
                return digits;
            }

        }
        int[] nums=new int[digits.length+1];
        nums[0]=1;

        return nums;
    }
}
