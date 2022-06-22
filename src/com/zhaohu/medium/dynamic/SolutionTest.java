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
    void uniquePaths(){
        int result= solution.uniquePaths(3,7);
        assertEquals(28,result);

        result= solution.uniquePaths(3,2);
        assertEquals(3,result);

        result= solution.uniquePaths(3,3);
        assertEquals(6,result);
    }
}