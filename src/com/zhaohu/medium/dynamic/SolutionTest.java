package com.zhaohu.medium.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @creator : zhaohu
 * @date : 6/21/2022
 * @description :
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void canJump() {
        int[] nums = new int[]{3, 2, 1, 0, 1, 2, 3};
        boolean result = solution.canJump(nums);
        assertEquals(false, result);
        nums = new int[]{3, 2, 1, 1, 2, 0, 4, 5};
        result = solution.canJump(nums);
        assertEquals(true, result);
        nums = new int[]{0};
        result = solution.canJump(nums);
        assertEquals(true, result);
        nums = new int[]{2, 0, 0};
        result = solution.canJump(nums);
        assertEquals(true, result);
        nums = new int[]{0, 1};
        result = solution.canJump(nums);
        assertEquals(false, result);
    }

    @Test
    void uniquePaths() {
        int result = solution.uniquePaths(3, 7);
        assertEquals(28, result);

        result = solution.uniquePaths(3, 2);
        assertEquals(3, result);

        result = solution.uniquePaths(3, 3);
        assertEquals(6, result);
    }

    @Test
    void coinChange() {
        int[] coins = new int[]{1, 2, 5, 10};
        int result = solution.coinChange(coins, 3);
        assertEquals(2, result);

        result = solution.coinChange(coins, 15);
        assertEquals(2, result);

        coins = new int[]{1, 2, 5, 11};
        result = solution.coinChange(coins, 15);
        assertEquals(3, result);

    }

    @Test
    void coinChange1() {
        int[] coins = new int[]{1, 2, 5, 10};
        int result = solution.coinChange1(coins, 3);
        assertEquals(2, result);

        result = solution.coinChange1(coins, 15);
        assertEquals(2, result);

        coins = new int[]{1, 2, 5, 11};
        result = solution.coinChange1(coins, 15);
        assertEquals(3, result);

        coins = new int[]{2};
        result = solution.coinChange1(coins, 3);
        assertEquals(-1, result);
    }

    @Test
    void lengthOfLIS() {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int result=solution.lengthOfLIS(nums);
        assertEquals(4,result);

        nums=new int[]{0,1,0,3,2,3};
        result= solution.lengthOfLIS(nums);
        assertEquals(4,result);

        nums=new int[]{7,7,7,7};
        result= solution.lengthOfLIS(nums);
        assertEquals(1,result);
    }
}