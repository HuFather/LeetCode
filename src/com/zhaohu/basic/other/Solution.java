package com.zhaohu.basic.other;

/**
 * @creator : zhaohu
 * @date : 5/23/2022
 * @description :
 */
public class Solution {
    public static void main(String[] args) {
        int result=hammingWeight(0b11111111111111111111111111111101);
    }
    public static int hammingWeight(int n){

        int oneNum=0;
        while (n!=0){
            if((n & 1) ==1)
                oneNum++;
            n>>>=1;

        }

        return oneNum;
    }
}
