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
        //int result = maxProfile(new int[]{7,1,5,3,6,4});
        int result = maxSubArray(new int[]{-2, -1, -3, -4, -1, -2, -1, -5, -4});
    }

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * f(x)
     * 状态转移：f(x)=f(x-1)+f(x-2)
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
     * 状态：当前的最大递增数列个数
     * x->f(x);f(x)=f(p)+1
     * 状态转移：f(x)->max(f(x),f(p)+1) => p<x and db[p]<db[x]
     * 2 5 3 6 1 7
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
     * 1. 没有买卖：ap(p-1)
     * 2. 刚买入：-prices[i]
     * =>f(p)=max(f(p-1)[0],-prices[p])
     * 2. 没有持有股票时的最大利润
     * 1. 没有买卖：dp(p-1)
     * 2. 在当前卖出：dp(p-1)+prices[p]
     * =>f(p)=max(f(p-1)[1],f(p-1)[0]+prices[p])
     *
     * @param
     * @return
     */
    public static int maxProfile1(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int no = -prices[0];
        int yes = 0;
        for (int i = 1; i < prices.length; i++) {
            no = Math.max(no, -prices[i]);
            yes = Math.max(yes, no + prices[i]);
        }
        return yes;
    }

    /**
     * 双指针，利用向前的特点，记录最小的数，以及最大值，取结束后的最大值即可
     *
     * @param nums
     * @return
     */
    public static int maxProfile(int[] nums) {
        if (null == nums || nums.length == 0)
            return 0;

        int max = 0;
        int start = nums[0];

        for (int i = 1; i < nums.length; i++) {
            start = Math.min(start, nums[i]);
            max = Math.max(max, nums[i] - start);
        }

        return max;
    }

    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 子数组 是数组中的一个连续部分。
     * 状态：f(x) x:已x结尾的最大字序和
     * 转移：f(x)=>max(f(x-1),0)+nums[x] x>p
     * -2,1,-3,4,-1,2,1,-5,4
     * 个人觉得，动态规划难在如何确认状态。正确的确立状态之后，转移方程和初始条件，边界条件都会简单很多。
     * <p>
     * 在确定状态时，一定要和转移方程地建立相适应。在本题中，同样建立一个dp[]数列来储存结果，如果将状态设定为，dp[i]用来表示，
     * 在i之前得到的最佳子序和，那么dp[i]和dp[i-1]之间便很难建立关系，因为仅仅是i之前得到的最佳子序和，最佳子序列可能与第i个元素相邻，也可能不相邻，
     * 这样就写不出状态转移方程。（如果这种建立状态的方法成立，最后需要返回的结果是dp[len-1]）
     * <p>
     * 正确是方法是dp[i]用来表示，终点在i的子序列的最佳子序和，这样dp[i]和dp[i-1]之间便有简单明了的关系。
     * 这时需要用到贪心法。此时，最后返回的值应该从dp数组中取最大值，即以i结尾的数组的最大子序和中找到最大的，
     * 作为整个数组的最佳子序和。
     * dp[i] = Math.max(dp[i - 1], 0) + num[i];
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int total = nums[0];
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(cur, 0) + nums[i];
            total = Math.max(total, cur);
        }

        return total;
    }

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     * 确定状态：上一个是否被偷
     * 当前不偷：f(x)=max(f(x-1)[1])
     * 当前偷：f(x)=max(f(x-1)[0])+nums[x]
     * 状态转移：
     * f(x)->max(max(f(x-1)[1],max(f(x-1)[0]+nums[x]) =>
     *
     * @param nums [10,5,3,66,4,7,8]
     * @return
     */
    public static int rob(int[] nums) {

        return 1;
    }
}
