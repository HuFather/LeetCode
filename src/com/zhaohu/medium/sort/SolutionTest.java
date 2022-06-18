package com.zhaohu.medium.sort;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @org.junit.jupiter.api.Test
    void merge() {
        int[][] result = solution.merge(new int[][]{{1, 4}, {4, 5}});
        assertEquals(result[0][0],1);
        assertEquals(result[0][1],5);
    }
}