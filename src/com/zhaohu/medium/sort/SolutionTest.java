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

    @Test
    void searchMatrix(){
        int[][] nums=new int[][]{
                {1,2,3,4,5,6},
                {7,8,9,10,11,12},
                {13,14,15,16,17,18}
        };
        boolean result=solution.searchMatrix(nums,3);
        assertEquals(true,result);
        result=solution.searchMatrix(nums,13);
        assertEquals(true,result);
        result=solution.searchMatrix(nums,19);
        assertEquals(false,result);
        nums=new int[][]{{1}};
        result=solution.searchMatrix(nums,1);
        assertEquals(true,result);
        result=solution.searchMatrix(nums,0);
        assertEquals(false,result);
    }

    @Test
    void search(){
        int result=solution.search(new int[]{4,5,6,7,0,1,2,},2);
        assertEquals(result,6);
        result=solution.search(new int[]{5,1,3},3);
        assertEquals(result,2);
        result=solution.search(new int[]{5,1,3},5);
        assertEquals(result,0);
        result=solution.search(new int[]{5,1,3},1);
        assertEquals(result,1);
        result=solution.search(new int[]{4,5,6,7,8,1,2,3},8);
        assertEquals(result,4);
        result=solution.search(new int[]{4,5,6,7,0,1,2},3);
        assertEquals(result,-1);
        result=solution.search(new int[]{3,1},1);
        assertEquals(result,1);
    }
}