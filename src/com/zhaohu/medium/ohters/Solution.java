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

}
