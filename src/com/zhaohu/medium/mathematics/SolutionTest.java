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

    @Test
    void trailingZeroes(){
        int result=solution.trailingZeroes(5);
        assertEquals(1,result);
        result=solution.trailingZeroes(2);
        assertEquals(0,result);

        result=solution.trailingZeroes(13);
        assertEquals(2,result);
    }

    @Test
    void titleToNumber(){
        int result = solution.titleToNumber("AB");
        assertEquals(701,result);
    }
}