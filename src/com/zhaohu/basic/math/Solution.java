package com.zhaohu.basic.math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        countPrimes(10);
    }
    /**
     * 给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
     * <p>
     * answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
     * answer[i] == "Fizz" 如果 i 是 3 的倍数。
     * answer[i] == "Buzz" 如果 i 是 5 的倍数。
     * answer[i] == i （以字符串形式）如果上述条件全不满足。
     *
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0)
                result.add("FizzBuzz");
            else if (i % 5 == 0)
                result.add("Buzz");
            else if (i % 3 == 0)
                result.add("Fizz");
            else
                result.add(String.valueOf(i));
        }

        return result;

    }

    /**
     * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量
     * @param n
     * @return
     */
    public static int countPrimes(int n){
        boolean[] counts=new boolean[n];
        int total=0;
        for (int i = 2; i <n ; i++) {
            if(counts[i]) continue;
            total++;
            for (int j = i; j <n ; j=j+i) {
                counts[j]=true;
            }
        }

        return total;
    }
}
