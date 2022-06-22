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
        if (nums[0] == 0 && nums.length > 1)
            return false;

        int[] jumps = new int[nums.length];
        jumps[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            jumps[i] = Math.max(jumps[i - 1], i + current);
            if (jumps[i] == i && i != nums.length - 1)
                return false;
        }

        return true;
    }


    /**
     * 不同路径
     * [1,1,1,1,1] 0,1,1,1,1
     * [1,1,1,1,1] 1,2,3,4,5
     * [1,1,1,1,1] 1,3,6,10,15
     * 从一个mxn的矩阵左上角到右下角，每次只能向上或向下，有多少种方式
     * 状态：f(x,y)->左上角到x有多少种方式
     * 转移：f(x,y)=f(x-1,y)+f(x,y-1)
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] nums = new int[m][n];
        for (int i = 0; i < n; i++) {
            nums[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            nums[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
            }
        }
        return nums[m - 1][n - 1];
    }
}
