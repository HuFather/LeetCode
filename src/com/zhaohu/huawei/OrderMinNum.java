package com.zhaohu.huawei;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 获取排序后最小的数字
 */
public class OrderMinNum {


    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }

        return sb.toString();
    }

    public String minNumber1(int[] nums) {
        PriorityQueue<String> queue = new PriorityQueue<>((x, y) -> (x + y).compareTo(y + x));
        for (int i = 0; i < nums.length; i++) {
            queue.offer(String.valueOf(nums[i]));
        }
        StringBuilder sb=new StringBuilder();
        while (!queue.isEmpty()){
            sb.append(queue.poll());
        }

        return sb.toString();
    }
}
