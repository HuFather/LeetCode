package com.zhaohu.hard.string;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void productExceptSelf() {
        int[] result = solution.productExceptSelf(new int[]{1, 2, 3, 4});

    }

    @Test
    void spiralOrder() {
        int[][] nums = new int[][]{{3}, {2}};
        List<Integer> result = solution.spiralOrder(nums);

    }

    @Test
    void gameofLife() {
        int[][] nums = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        solution.gameOfLife(nums);
    }

    @Test
    void firstMissingPositive() {
        int[] nums=new int[]{1,2,0};
        int result = solution.firstMissingPositive(nums);
        assertEquals(3,result);
        nums=new int[]{7,8,9,11,12};
        result=solution.firstMissingPositive(nums);
        assertEquals(10,result);
    }
}