package com.zhaohu.medium.mathematics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution=new Solution();
    @Test
    void isHappy() {
        boolean result = solution.isHappy(2);
        assertEquals(false,result);
    }
}