package com.zhaohu.basic.dynamicplanning;

import java.util.List;

/**
 * @creator : zhaohu
 * @date : 5/16/2022
 * @description :
 */
public class Solution {

    public static void main(String[] args) {
        // climbStairs(1);
        // findMaxSeries(new int[]{0, 1, 5, 3, 4, 6, 9, 7, 8});
        int result = maxProfile(new int[]{});

    }

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int[] allSteps = new int[n + 2];
        allSteps[0] = 0;
        allSteps[1] = 1;
        allSteps[2] = 2;
        for (int i = 3; i <= n; i++) {
            int steps = allSteps[i - 2] + allSteps[i - 1]; //状态转移
            allSteps[i] = steps;
        }
        return allSteps[n];
    }

    /**
     * 1,5,11 大小的纸币，找出最小组合数
     *
     * @param n 要组合的总钱数
     * @return
     */
    public static void minCoins(int n) {
        int[] costs = new int[n + 1];
        costs[0] = 0;
        for (int i = 1; i <= n; i++) {

            int cost = Integer.MAX_VALUE;
            if (i - 1 >= 0) cost = Math.min(cost, costs[i - 1] + 1);
            if (i - 5 >= 0) cost = Math.min(cost, costs[i - 5] + 1);
            if (i - 11 >= 0) cost = Math.min(cost, costs[i - 11] + 1);

            costs[i] = cost;

            System.out.printf("n为%d时，最少需要%d张", i, cost);
            System.out.println();
        }

    }

    /**
     * 找出最长递增数列
     * x->f(x);f(x)=f(p)+1
     *
     * @param nums
     * @return
     */
    public static int findMaxSeries(int[] nums) {
        int[] numL = new int[nums.length];
        for (int i = 0; i < numL.length; i++) {
            numL[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < i; j++) {
                if (nums[j] < nums[i])
                    numL[i] = Math.max(numL[i], numL[j] + 1);
            }
            System.out.printf("%d = %d", i, numL[i]);
            System.out.println();
        }
        int ans = 0;
        for (int x : numL) {
            ans = Math.max(ans, x);
        }
        return ans;
    }
    /**
     * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
     * <p>
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     * 7, 2, 5, 3, 6, 4,9
     * 0,3,3,6,6,9
     * 分为两种情况
     * 1. 持有股票时的最大利润
     *  1. 没有买卖：ap(p-1)
     *  2. 刚买入：-prices[i]
     *  =>f(p)=max(f(p-1)[0],-prices[p])
     * 2. 没有持有股票时的最大利润
     *  1. 没有买卖：dp(p-1)
     *  2. 在当前卖出：dp(p-1)+prices[p]
     *  =>f(p)=max(f(p-1)[1],f(p-1)[0]+prices[p])
     * @param
     * @return
     */
    public static int maxProfile1(int[] prices){
        if(prices ==null || prices.length==0)
            return 0;
        int no=-prices[0];
        int yes=0;
        for (int i = 1; i < prices.length; i++) {
            no=Math.max(no,-prices[i]);
            yes=Math.max(yes,no+prices[i]);
        }
        return yes;
    }
    public static int maxProfile(int[] nums) {
        int[] result = new int[nums.length + 1];
        result[0] = 0;
        int index = 1;
        for (int i = 1; i < nums.length; i++) {

            result[i] = Math.max(result[i - 1], result[i - 1] + nums[i] - nums[index]);

        }

        int max = 0;
        for (int i = 0; i < result.length; i++) {
            max = Math.max(max, result[i]);
        }

        return max;
    }
}
