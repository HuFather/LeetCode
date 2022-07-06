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

    @Test
    void divide() {
        int result=solution.divide(10,3);
        assertEquals(3,result);
    }

    @Test
    void quickAdd() {
    }

    @Test
    void fractionToDecimal() {
        String result = solution.fractionToDecimal(1,2);
        assertEquals("0.5",result);

        result=solution.fractionToDecimal(4,333);
        assertEquals("0.(012)",result);

        result=solution.fractionToDecimal(-1,-2147483648);

    }
}