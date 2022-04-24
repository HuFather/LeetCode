package com.zhaohu.basic.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TheSum {
    public static void main(String[] args) {
        twoSum(new int[]{2,7,11,15},9);
    }
    public static int[] twoSum(int[] numbers,int target){
        Map<Integer,Integer> map=new HashMap<>();
        int[] ans=new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if(map.containsKey(target-numbers[i])){
                ans[0]=i;
                ans[1]=map.get(target-numbers[i]);
                return ans;
            }else {
                map.put(numbers[i],i);
            }
        }

        return ans;
    }
}
