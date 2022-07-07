package com.zhaohu.medium.ohters;

import java.util.Arrays;
import java.util.Stack;

import org.apache.commons.lang3.math.NumberUtils;


public class Solution {


    /**
     * 两整数之和
     *
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }

        return a;
    }


    /**
     * 逆波兰表达式求值
     * 1 3 + 5 *=（1+3）*5
     * ["10","6","9","3","+","-11","*","/","*","17","+","5","+"] = ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<String> eval = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            eval.push(tokens[i]);
        }
        return execute(eval, eval.pop());
    }

    private int execute(Stack<String> eval, String oper) {
        if (eval.size() > 0) {

            String middle = eval.pop();
            if (!NumberUtils.isParsable(middle)) {
                middle = String.valueOf(execute(eval, middle));
            }
            String left = eval.pop();
            if (!NumberUtils.isParsable(left)) {
                left = String.valueOf(execute(eval, left));
            }

            Operation operation = Arrays.stream(Operation.values()).filter(r->r.isTarget(oper)).findFirst().get();
            int result = operation.execute(Integer.valueOf(left),Integer.valueOf(middle));

            return result;
        }
        return 0;
    }

    public enum Operation {
        PLUS("+") {
            @Override
            public int execute(int left, int right) {
                return left + right;
            }
        },
        SUBTRACT("-") {
            @Override
            public int execute(int left, int right) {
                return left - right;
            }
        },
        MULTIPLY("*") {
            @Override
            public int execute(int left, int right) {
                return left * right;
            }
        },
        DIVIDE("/") {
            @Override
            public int execute(int left, int right) {
                return left / right;
            }
        };

        private String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public boolean isTarget(String operation) {
            return this.operation.equals(operation);
        }

        public abstract int execute(int left, int right);
    }

    /**
     * 【1，2，3，3，3，2】
     * 找出多数数字
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count=1;
        int num=nums[0];

        for (int i = 1; i < nums.length; i++) {
            if(count==0){
                count=1;
                num=nums[i];
            }else {
                if(num==nums[i])
                    count++;
                else {
                    count--;
                }
            }
        }
        return num;
    }

    /**
     * 给你一个用字符数组tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
     * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
     * 你需要计算完成所有任务所需要的 最短时间
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {

        return 1;
    }

}
