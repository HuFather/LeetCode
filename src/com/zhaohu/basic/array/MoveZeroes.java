package com.zhaohu.basic.array;

public class MoveZeroes {
    public static void main(String[] args) {
        IntersectionCollection.xxx="ss";
    }
    public void moveZeroes1(int[] nums){
        int index=0;
        int copy=0;
        while (index<nums.length){
            if(nums[index]==0){
                copy++;
            }else if(copy!=0){

                nums[index-copy]=nums[index];
                nums[index]=0;
            }
            index++;
        }

    }
}
