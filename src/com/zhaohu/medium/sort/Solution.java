package com.zhaohu.medium.sort;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};

        sortColors(nums);
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
}
