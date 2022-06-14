package com.zhaohu.medium.sort;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{3,3,5,5,3,5,5,6};

        int[] result= topKFrequent(nums,2);
    }

    /**
     * 颜色分类
     *
     * @param nums
     */
    public static void sortColors(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        for (int i = 0; i <= right; i++) {

            if (nums[i] == 2) {
                change(nums, i, right);
                right--;
                i--;
            } else if (nums[i] == 0) {
                change(nums, i, left);
                left++;
            }
        }


    }

    static void change(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    /**
     * 找出出现频率前k高的元素
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] result=new int[k];
        int[] maxs=new int[k];
        for (int i = 0; i < nums.length; i++) {
            Integer value= map.put(nums[i],map.getOrDefault(nums[i],0)+1);

        }

        return result;

    }

    public int[] topKFrequent1(int[] nums, int k) {
        //先统计每个数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        //最大堆
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int key : map.keySet())
            priorityQueue.add(new int[]{key, map.get(key)});

        //取堆中最大的k个元素
        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = priorityQueue.poll()[0];
        return res;
    }

}
