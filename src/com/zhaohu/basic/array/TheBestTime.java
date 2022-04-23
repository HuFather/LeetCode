package com.zhaohu.basic.array;

/**
 * 给定一个数组 prices ，其中 prices[i] 表示股票第 i 天的价格。
 * <p>
 * 在每一天，你可能会决定购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以购买它，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2zsx1/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class TheBestTime {
    public static void main(String[] args) {
        maxProfit(new int[]{1, 2, 3, 4, 5});
    }

    /**
     * 贪心算法
     *
     * @param prices
     * @return
     */
    private static int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;

        int total = 0;
        int index = 0;
        int length = prices.length;

        while (index < length) {
            while (index < length-1 && prices[index] >= prices[index + 1])
                index++;

            int min = prices[index];

            while (index< length-1 && prices[index] <= prices[index + 1])
                index++;

            total += prices[index++] - min;
        }

        return total;
    }
}
