package com.zhaohu.medium.dynamic;

/**
 * @creator : zhaohu
 * @date : 6/21/2022
 * @description :
 */
public class Solution {

    /**
     * 跳跃游戏
     * [3，2，1，0，1，2，3]
     * 1. 如果没有0，则都能到最后
     * 2. 如果有0，但是能跳过0，也能到最后
     * 3. 如果有0，但是无法跳过，则不能到最后
     * 状态，当前能前进到的最远坐标
     * 转换，f(x)=max(f(x-1),a(x))
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        if(nums[0]==0 && nums.length>1)
            return false;

        int[] jumps = new int[nums.length];
        jumps[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            jumps[i] = Math.max(jumps[i - 1], i + current);
            if (jumps[i] == i && i!=nums.length-1)
                return false;
        }

        return true;
    }
}
