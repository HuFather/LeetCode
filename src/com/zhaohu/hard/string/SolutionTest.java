package com.zhaohu.hard.string;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution=new Solution();
    @Test
    void productExceptSelf() {
       int[] result= solution.productExceptSelf(new int[]{1,2,3,4});

    }

    @Test
    void spiralOrder() {
        int[][] nums=new int[][]{{3},{2}};
        List<Integer> result= solution.spiralOrder(nums);

    }
}