package com.zhaohu.basic.array;

public class RotateArray {
    public static void main(String[] args) {
        //int[] nums = new int[]{1,2,3,4,5,6,7};
        //int[] nums = new int[]{-1, -100, 3, 99};
        int[] nums = new int[]{1};
        rotate2(nums, 0);
    }

    public static void rotate(int[] nums, int k) {
        if (k > nums.length)
            k = k % nums.length;
        int[] newNums = new int[nums.length];
        k = newNums.length - k;
        for (int i = k; i < nums.length; i++) {
            newNums[i - k] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            newNums[nums.length - k + i] = nums[i];
        }
        for (int i = 0; i < newNums.length; i++) {
            nums[i] = newNums[i];
        }
    }

    /**
     * 临时数组
     *
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = result[i];
        }
    }

    /**
     * 翻转
     *
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {
        // 翻转全部
        k = k % nums.length;
        rt(nums, 0, nums.length - 1);
        rt(nums, 0, k-1);
        rt(nums, k, nums.length - 1);
    }

    public static void rt(int[] nums, int start, int end) {
        while (start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
