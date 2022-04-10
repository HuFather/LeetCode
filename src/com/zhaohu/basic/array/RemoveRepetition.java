package com.zhaohu.basic.array;

/**
 * 移除按照升序排序的数组中重复的元素
 * 要求，原地
 */
public class RemoveRepetition {
    public static void main(String[] args) {
        int[] nums=new int[]{1,1,2};
        int s=removeDuplicates1(nums);
    }

    //双指针
    private static int removeDuplicates(int[] nums){

        int result=0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]!=nums[result]){
                result++;
                nums[result]=nums[i];
            }
        }

        return result +1;
    }

    private static int removeDuplicates1(int[] nums){
        int count=0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1]){
                count++;
            }else {
                nums[i-count]=nums[i];
            }
        }

        return nums.length-count;
    }
}
