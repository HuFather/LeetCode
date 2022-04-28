package com.zhaohu.basic.array;

import java.util.HashSet;

public class RepetitionNum {
    public static void main(String[] args) {
        singleNumber(new int[]{2,2,1});
    }
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> num = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (num.contains(nums[i]))
                return true;
            num.add(nums[i]);
        }
        return false;
    }

    public static int singleNumber(int[] nums) {

        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;
    }

}
