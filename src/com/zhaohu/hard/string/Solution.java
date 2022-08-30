package com.zhaohu.hard.string;

import javafx.scene.Group;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @creator : zhaohu
 * @date : 7/9/2022
 * @description :
 */
public class Solution {
    /**
     * 除自身为数组的乘积
     *
     * @param nums
     * @return
     * @throws IOException
     */
    public int[] productExceptSelf(int[] nums) {
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];

        L[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }

        R[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = L[i] * R[i];
        }

        return result;
    }


    /**
     * 顺时针螺旋顺序
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int time = 0;
        List<Integer> result = new ArrayList<>();

        while (n >= time && m >= time) {
            for (int i = time; i <= n - time; i++) {
                result.add(matrix[time][i]);
            }
            for (int i = time + 1; i <= m - time; i++) {
                result.add(matrix[i][n - time]);
            }
            for (int i = n - time - 1; i > time; i--) {
                result.add(matrix[m - time][i]);
            }
            for (int i = m - time; i >= time + 1; i--)

                time++;
        }

        return result;
    }

    /**
     * 最大面积
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        while (left <= right) {
            int result = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(result, ans);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }

    /**
     * 生命游戏，复制数组解决
     *
     * @param board
     */
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int column = board[0].length;

        int[][] replicas = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                replicas[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int liveNum = 0;
                //获取周围的活细胞数量
                for (int k = -1; k < 2; k++) {
                    for (int l = -1; l < 2; l++) {
                        int r = i + k;
                        int c = j + l;
                        if (!(r == i && c == j) && r >= 0 && c >= 0 && r < row && c < column && replicas[r][c] == 1) {
                            liveNum++;
                        }
                    }
                }

                if (replicas[i][j] == 1 && (liveNum < 2 || liveNum > 3)) {
                    board[i][j] = 0;
                }
                if (replicas[i][j] == 0 && liveNum == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    /**
     * 缺失的第一个整数
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0)
                nums[i] = nums.length + 1;
        }

        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num <= nums.length) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                return i + 1;
        }

        return nums.length + 1;
    }

    /**
     * 最长连续序列
     *
     * @param nums 1,3,5,2,4,6
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Set<Integer> temp = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            temp.add(nums[i]);
        }

        int max=Integer.MIN_VALUE;
        for (int key:temp){
            if(!temp.contains(key-1)){
                int num=1;
                while (temp.contains(key+1)){
                    num++;
                    key+=1;
                }
                max=Math.max(max,num);
            }
        }

        return max;
    }

    /**
     * 寻找重复数
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int low=0,fast=0;
        do{
            low=nums[low];
            fast=nums[nums[fast]];
        }
        while (low!=fast);

        low=0;
        while (low!=fast){
            low=nums[low];
            fast=nums[fast];
        }

        return low;
    }

    /**
     * 基本计算器
     * @param s
     * @return
     */
    public int calculate(String s) {
        Deque<Integer> stack=new ArrayDeque<>();

        char preCalculate='+';
        int num=0;

        for (int i = 0; i <s.length() ; i++) {
            if(Character.isDigit(s.charAt(i))){
                num=num*10+s.charAt(i)-'0';
            }
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i)!=' ' || i==s.length()-1){
                switch (preCalculate){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop()*num);
                        break;
                    case '/':
                        stack.push(stack.pop()/num);
                        break;
                }
                preCalculate=s.charAt(i);
                num=0;
            }
        }
        int result=0;
        while (!stack.isEmpty()){
            result+=stack.pop();
        }

        return result;
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer[]> stack = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        for (int i = 0; i < k; i++) {
            stack.add(new Integer[]{nums[i], i});
        }

        int[] result = new int[nums.length - k + 1];
        result[0] = stack.peek()[0];
        for (int i = k; i < nums.length; i++) {
            stack.add(new Integer[]{nums[i], i});
            while (stack.peek()[1] <= i - k) {
                stack.poll();
            }
            result[i - k + 1] = stack.peek()[0];
        }

        return result;
    }


    private int maxNum(int[] nums, int start, int end) {
        int max = nums[start];
        for (int i = start + 1; i <= end; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    /**
     * 最小覆盖子串
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        return "";
    }

}
