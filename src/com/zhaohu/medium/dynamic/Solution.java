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


    /**
     * 计算钱币
     * 用最少的数量组合出目标数
     * 1 5 11  =  17
     * <p>
     * 状态：
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] result = new int[coins.length];
        int max = Integer.MAX_VALUE;
        for (int i = coins.length - 1; i >= 0; i--) {
            int start = i;
            int num = 0;
            int value = amount;
            while (start >= 0) {
                num += value / coins[start];
                int n = value % coins[start];
                if (n == 0)
                    break;
                value = n;
                start--;
            }
            result[i] = num;
            max = max > num ? num : max;
        }

        return max;
    }

    /**
     * 状态：当前能组合的最小数量
     * 转移：f(x)=min(f(j)+1) j<x
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange1(int[] coins, int amount) {
        int[] result = new int[amount + 1];
        for (int i = 1; i < result.length; i++) {
            result[i] = -1;
        }

        for (int i = 1; i <= amount; i++) {
            int num = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                if (i - coin >= 0 && result[i - coin] != -1) {
                    num = num > result[i - coin] + 1 ? result[i - coin] + 1 : num;
                    result[i] = num;
                }
            }

        }

        return result[amount];
    }


    /**
     * 最长递增子序列
     * state: current highest order
     * transfer: f(x)=
     * [10,9,2,5,3,7,101,18]
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] result = new int[nums.length];
        result[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i] && result[j] >= result[i]) {
                    result[i] = result[j] + 1;
                }
            }
            max = result[i] > max ? result[i] : max;
            if (result[i] == 0)
                result[i] = 1;
        }

        return max;
    }


    /**
     * 求x的n次幂
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        double result = 1;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                result *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / result : result;
    }

    /**
     * x的平方根
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int result=0;
        while (left<=right){
            int mid=left+(right-left)/2;
            if((long)mid*mid<=x){
                result=mid;
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return result;
    }

    public int mySql1(int x){
        if(x==0)
            return 0;
        double c=x,x0=x;
        while (true){
            double xi=0.5*(x0+c/x0);
            if(Math.abs(x0-xi)<1e-7){
                break;
            }
            x0=xi;
        }
        return (int) x0;
    }

    public int divide(int dividend, int divisor) {
        if(divisor==1)
            return dividend;

        return 1;
    }
}
