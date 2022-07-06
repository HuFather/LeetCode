package com.zhaohu.medium.ohters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @creator : zhaohu
 * @date : 7/6/2022
 * @description :
 */
class SolutionTest {

    Solution solution=new Solution();
    @Test
    void evalRPN() {
        String[] rpn=new String[]{"1","3","+","5","*"};
        int result= solution.evalRPN(rpn);
        assertEquals(20,result);

        rpn=new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        result=solution.evalRPN(rpn);
        assertEquals(22,result);
    }
}